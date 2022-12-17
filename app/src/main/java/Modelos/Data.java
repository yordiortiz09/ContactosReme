package Modelos;

import java.util.List;

public class Data {

    List<Contacto> data;

    public Data(List<Contacto> data) {
        this.data = data;
    }

    public List<Contacto> getData() {
        return data;
    }

    public void setData(List<Contacto> data) {
        this.data = data;
    }


}
