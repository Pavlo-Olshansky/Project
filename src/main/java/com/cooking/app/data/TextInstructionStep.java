package com.cooking.app.data;

import com.cooking.app.services.InstructionStep;

import java.util.UUID;

public class TextInstructionStep implements InstructionStep {
  private   String text;
  private   String id;

    public TextInstructionStep() {
        id = UUID.randomUUID().toString();
    }


    public TextInstructionStep(String text  ) {
        this();
        this.text = text;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public  String getText(){return text;}

    public void setText(String text){this.text = text;}

    @Override
    public String print(){
        return "TODO";
    }

}
