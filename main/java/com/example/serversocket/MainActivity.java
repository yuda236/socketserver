package com.example.serversocket;

import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.example.serversocket.helper.JsonParsingHelper;
import com.example.serversocket.helper.RetrieveData;
import com.example.serversocket.model.ChatModel;
import com.example.serversocket.model.MultipleChoiceModel;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.tv_text)
    TextView tvText;
    @BindView(R.id.tv_ip_address)
    TextView tvIpAddress;
    @BindView(R.id.tv_port)
    TextView tvPort;
    @BindView(R.id.tv_status)
    TextView tvStatus;
    private Handler updateConversationHandler;
    Thread serverThread = null;

    public static String IP_ADDRESS = "";
    public static int PORT = 8080;
    private PrintWriter output;
    private BufferedReader input;
    private Thread Thread1 = null;
    private ServerSocket serversocket;

    Map<Integer, Integer> mapping;
    List<ChatModel> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        init();

        tvText.setText("");
        try {
            IP_ADDRESS = getLocalIpAddress();

        } catch (UnknownHostException e) {
            e.printStackTrace();
            Toast.makeText(this, "system error  ex : " + e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
        }
        Thread1 = new Thread(new Thread1());
        Thread1.start();

    }

    private void init() {

        RetrieveData source = new RetrieveData();
        data = source.getData();
        mapping = new HashMap<>();
        for (int i = 0; i < data.size(); i++) {
            ChatModel c = data.get(i);
            mapping.put(c.getId(), i);
        }

    }

    private String getLocalIpAddress() throws UnknownHostException {
        WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);
        assert wifiManager != null;
        WifiInfo wifiInfo = wifiManager.getConnectionInfo();
        int ipInt = wifiInfo.getIpAddress();
        return InetAddress.getByAddress(
                ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(ipInt).array())
                .getHostAddress();
    }

    private class Thread1 implements Runnable {
        public Thread1() {
        }

        @Override
        public void run() {
            Socket socket;
            try {
                serversocket = new ServerSocket(PORT);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        tvIpAddress.setText("IP ADDRESS : " + IP_ADDRESS);
                        tvPort.setText("PORT : " + String.valueOf(PORT));
                        tvStatus.setText("STATUS : NOT CONNECTED");

                    }
                });
                try {
                    socket = serversocket.accept();
                    output = new PrintWriter(socket.getOutputStream());
                    input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            tvStatus.setText("STATUS : CONNECTED");
                        }
                    });

                } catch (IOException e) {
                    e.printStackTrace();
                }
                new Thread(new Thread2()).start();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    private class Thread2 implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    final String message = input.readLine();

                    if (message != null) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
//                                tvText.append("from client:" + message + "\n");
//                                new Thread(new ThreadSendMessage("diterima")).start();
                                retrieve_message(message);
                            }
                        });


                    } else {
                        Thread1 = new Thread(new Thread1());
                        Thread1.start();
                        return;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    private void retrieve_message(String message) {
        if (message.equals("start")) {
            ChatModel c = data.get(0);
            String send_data = JsonParsingHelper.ParseToJson(c);
            tvText.setText("from client : " + message + "\n");
            new Thread(new ThreadSendMessage(send_data)).start();
        } else {
            Gson gson = new Gson();
            String strTemp = message;
            ChatModel cmTemp = gson.fromJson(message, ChatModel.class);
            int id = cmTemp.getId();
            int index = mapping.get(id);
            boolean wassend = cmTemp.isWas_send();
            int typeChat = cmTemp.getTypechat();
            int indexAnswer = cmTemp.getIndex_answer();
            if (typeChat == 1 && wassend == true) {
                int next_id = cmTemp.getNext_id();
                if (next_id != -1) {
                    int indexnextid = mapping.get(next_id);
                    ChatModel cmSend = data.get(indexnextid);
                    String strSend = gson.toJson(cmSend);
                    new Thread(new ThreadSendMessage(strSend)).start();
                } else {
                    Thread1 = new Thread(new Thread1());
                    Thread1.start();
                    return;
                }
            } else if (typeChat == 2 && wassend == true) {
                int next_id = cmTemp.getNext_id();
                if (next_id != -1) {
                    int indexnextid = mapping.get(next_id);
                    ChatModel cmSend = data.get(indexnextid);
                    String strSend = gson.toJson(cmSend);
                    new Thread(new ThreadSendMessage(strSend)).start();
                } else {
                    Thread1 = new Thread(new Thread1());
                    Thread1.start();
                    return;
                }
            } else if (typeChat == 3) {
                List<MultipleChoiceModel> multis = cmTemp.getMultiplechoice();
                int next_id = multis.get(indexAnswer - 1).getNext_id();
                if (next_id != -1) {
                    int indexnextid = mapping.get(next_id);
                    ChatModel cmSend = data.get(indexnextid);
                    String strSend = gson.toJson(cmSend);
                    new Thread(new ThreadSendMessage(strSend)).start();
                }else{
                    Thread1 = new Thread(new Thread1());
                    Thread1.start();
                    return;
                }
            }


        }

    }

    private class ThreadSendMessage implements Runnable {
        private String message;

        ThreadSendMessage(String message) {
            this.message = message;
        }

        @Override
        public void run() {
            output.println(message);
            output.flush();
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    tvText.append("to client: " + message + "\n");
                }
            });
        }
    }
}
