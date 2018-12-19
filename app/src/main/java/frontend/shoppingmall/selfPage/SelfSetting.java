package frontend.shoppingmall.selfPage;

public class SelfSetting {
    private int imageId;
    String content;
    public SelfSetting(int imageId,String content){
        this.imageId = imageId;
        this.content = content;
    }

    public int getImageId() {
        return imageId;
    }

    public String getContent() {
        return content;
    }
}
