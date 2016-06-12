package com.cooking.app.data;

import com.cooking.app.services.InstructionStep;

import java.io.File;
import java.util.UUID;

public class PhotoInstructionStep implements InstructionStep {
    private String id;
    private File photo;

    public PhotoInstructionStep() {
        id = UUID.randomUUID().toString();
    }


    public PhotoInstructionStep(File photo) {
        this();
        this.photo = photo;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public  File getPhoto(){return photo;}

    public void setPhoto(File photo){this.photo = photo;}

    @Override
    public String print(){
        return "TODO";
    }

}



