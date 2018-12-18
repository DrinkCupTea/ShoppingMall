package frontend.shoppingmall.messagePage;

public class Contacts {
    private String name,message,time;
    private int imageId;
    public Contacts(String name,String message,String time,int imageId){
        this.name = name;
        this.message = message;
        this.time = time;
        this.imageId = imageId;
    }
    public String getName(){
        return name;
    }
    public String getMessage(){
        return message;
    }
    public String getTime(){
        return time;
    }
    public int getImageId(){
        return imageId;
    }
}
