package com.example.serversocket.helper;

import com.example.serversocket.model.ChatModel;
import com.example.serversocket.model.MultipleChoiceModel;

import java.util.ArrayList;
import java.util.List;

public class RetrieveData {

    List<ChatModel> data;

    public RetrieveData() {
        data = new ArrayList<ChatModel>();
        generateData1();
        generateData2();
        generateData3();
        generateData4();
        generateData5();
        generateData6();
        generateData7();
        generateData8();
        generateData9();
        generateData97();
        generateData98();
        generateData99();
        generateData10();

    }


    public List<ChatModel> getData() {
        return data;
    }

    public void setData(List<ChatModel> data) {
        this.data = data;
    }

    public void generateData1(){
        ChatModel c =  new ChatModel();
        c.setId(1);
        c.setTypechat(1);
        c.setText("hallo");
        c.setImagesrc("");
        c.setIndex_answer(-1);
        c.setNext_id(10);
        c.setNeed_answer(false);
        c.setWas_send(false);
        data.add(c);
    }
    public void generateData2(){
        ChatModel c =  new ChatModel();
        c.setId(2);
        c.setTypechat(1);
        c.setText("Apakah Anda Suka Harry Potter ?");
        c.setIs_Answer(false);
        c.setImagesrc("");
        c.setIndex_answer(-1);
        c.setNext_id(3);
        c.setNeed_answer(false);
        c.setWas_send(false);
        data.add(c);
    }
    public void generateData3(){
        ChatModel c =  new ChatModel();
        c.setId(3);
        c.setTypechat(3);
        c.setText("");
        c.setIs_Answer(false);
        List<MultipleChoiceModel> multis = new ArrayList<MultipleChoiceModel>();
        multis.add(new MultipleChoiceModel("A.","Ya",9));
        multis.add(new MultipleChoiceModel("B.","Tidak",98));
        c.setMultiplechoice(multis);
        c.setImagesrc("");
        c.setIndex_answer(-1);
        c.setNext_id(-2);
        c.setNeed_answer(true);
        c.setWas_send(false);
        data.add(c);
    }
    public void generateData4(){
        ChatModel c =  new ChatModel();
        c.setTypechat(3);
        c.setId(4);
        c.setText("");
        c.setIs_Answer(false);
        List<MultipleChoiceModel> multis = new ArrayList<MultipleChoiceModel>();
        multis.add(new MultipleChoiceModel("A.","Harry",5));
        multis.add(new MultipleChoiceModel("B.","Hermione",6));
        multis.add(new MultipleChoiceModel("C.","Mbah Surip",97));
        c.setMultiplechoice(multis);
        c.setImagesrc("");
        c.setIndex_answer(-1);
        c.setNext_id(-2);
        c.setNeed_answer(true);
        c.setWas_send(false);
        data.add(c);
    }
    public void generateData5(){
        ChatModel c =  new ChatModel();
        c.setTypechat(2);
        c.setId(5);
        c.setText("");
        c.setIs_Answer(false);
        c.setImagesrc("https://firebasestorage.googleapis.com/v0/b/chattingprixaai.appspot.com/o/harrypotter.jpg?alt=media&token=d5111444-f37b-438f-80ae-78c608004ac6");
        c.setIndex_answer(0);
        c.setNext_id(7);
        c.setNeed_answer(false);
        c.setWas_send(false);
        data.add(c);
    }
    public void generateData6(){
        ChatModel c =  new ChatModel();
        c.setTypechat(2);
        c.setId(6);
        c.setText("");
        c.setIs_Answer(false);
        c.setImagesrc("https://firebasestorage.googleapis.com/v0/b/chattingprixaai.appspot.com/o/hermione.jpg?alt=media&token=323be210-de07-4bf8-9239-dce07346b5d0");
        c.setIndex_answer(0);
        c.setNext_id(7);
        c.setNeed_answer(false);
        c.setWas_send(false);
        data.add(c);
    }
    public void generateData7(){
        ChatModel c =  new ChatModel();
        c.setId(7);
        c.setTypechat(1);
        c.setText("mau codingnya.");
        c.setIs_Answer(false);
        c.setImagesrc("");
        c.setIndex_answer(-1);
        c.setNext_id(8);
        c.setNeed_answer(false);
        c.setWas_send(false);
        data.add(c);
    }
    public void generateData8(){
        ChatModel c =  new ChatModel();
        c.setId(8);
        c.setTypechat(1);
        c.setText("silahkan hubungi OmDa.");
        c.setIs_Answer(false);
        c.setImagesrc("");
        c.setIndex_answer(-1);
        c.setNext_id(99);
        c.setNeed_answer(false);
        c.setWas_send(false);
        data.add(c);
    }
    public void generateData9(){
        ChatModel c =  new ChatModel();
        c.setId(9);
        c.setTypechat(1);
        c.setText("Siapa Tokoh Favorite anda di film tersebut");
        c.setIs_Answer(false);
        c.setImagesrc("");
        c.setIndex_answer(-1);
        c.setNext_id(4);
        c.setNeed_answer(false);
        c.setWas_send(false);
        data.add(c);
    }
    public void generateData10(){
        ChatModel c =  new ChatModel();
        c.setTypechat(2);
        c.setId(10);
        c.setText("");
        c.setIs_Answer(false);
        c.setImagesrc("https://firebasestorage.googleapis.com/v0/b/chattingprixaai.appspot.com/o/harry%20potter.jpg?alt=media&token=372da237-9e66-401b-860a-226f63b2bf76");
        c.setIndex_answer(0);
        c.setNext_id(2);
        c.setNeed_answer(false);
        c.setWas_send(false);
        data.add(c);
    }


    public void generateData97(){
        ChatModel c =  new ChatModel();
        c.setId(97);
        c.setTypechat(1);
        c.setText("Tukang boong kamu.... mbah surip cuman bisa tak gendong kemana mana.");
        c.setIs_Answer(false);
        c.setImagesrc("");
        c.setIndex_answer(-1);
        c.setNext_id(99);
        c.setNeed_answer(false);
        c.setWas_send(false);
        data.add(c);
    }
    public void generateData98(){
        ChatModel c =  new ChatModel();
        c.setId(98);
        c.setTypechat(1);
        c.setText("yahh tidak suka harry potter.");
        c.setIs_Answer(false);
        c.setImagesrc("");
        c.setIndex_answer(-1);
        c.setNext_id(99);
        c.setNeed_answer(false);
        c.setWas_send(false);
        data.add(c);
    }
    public void generateData99(){
        ChatModel c =  new ChatModel();
        c.setId(99);
        c.setTypechat(1);
        c.setText("byee......");
        c.setIs_Answer(false);
        c.setImagesrc("");
        c.setIndex_answer(-1);
        c.setNext_id(-1);
        c.setNeed_answer(false);
        c.setWas_send(false);
        data.add(c);
    }

}
