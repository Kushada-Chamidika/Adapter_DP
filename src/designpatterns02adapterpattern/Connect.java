package designpatterns02adapterpattern;

interface SDCard {

    public abstract void readSDCard();

}

interface MicroSDCard {

    public abstract void readMicroSDCard();

}

class MySDCard implements SDCard {

    String SDSize;

    @Override
    public void readSDCard() {
        System.out.println("SD Capacity -> " + SDSize + " / Reading SD Card");
    }
}

class MyMicroSDCard implements MicroSDCard {

    String MicroSDSize;

    @Override
    public void readMicroSDCard() {
        System.out.println("Micro SD Capacity -> " + MicroSDSize + " / Reading Micro SD Card");
    }
}

class LapTop {

    SDCard sd;

    public void readData() {
        sd.readSDCard();
    }

}

class SDAdapter implements SDCard {

    MicroSDCard microSDCard;

    @Override
    public void readSDCard() {
        microSDCard.readMicroSDCard();
    }
}

public class Connect {

    public static void main(String[] args) {
        MySDCard mSDcard = new MySDCard();
        mSDcard.SDSize = "32GB";

        MyMicroSDCard mMicroSDcard = new MyMicroSDCard();
        mMicroSDcard.MicroSDSize = "32GB";

        LapTop lapTop = new LapTop();

        lapTop.sd = mSDcard;
        lapTop.readData();

        SDAdapter adapter = new SDAdapter();
        adapter.microSDCard = mMicroSDcard;

        lapTop.sd = adapter;
        lapTop.readData();
    }

}
