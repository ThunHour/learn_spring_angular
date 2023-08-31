import java.util.ArrayList;
public class App {
    public static void main(String[] args) throws Exception {
        Iphone3G newModelIpone=new Iphone3G();
        newModelIpone.ram();
        newModelIpone.camera();
        newModelIpone.screen();
        newModelIpone.shape();
        newModelIpone.speaker();
        ArrayList<item> item=new ArrayList<item>();
        item.add(0, new item("seakkimhour", "2138123", "kimhour.png"));
        item.add(1, new item("seakkimhour", "2138123", "kimhour.png"));
        item.add(2, new item("seakkimhour", "2138123", "kimhour.png"));
        item.add(3, new item("seakkimhour", "2138123", "kimhour.png"));
 item.forEach((x)->{
    System.out.println(String.format("ID:%s, Name:%s ,Picture:%s", x.getId(),x.getName(),x.getPic()));
 });
    }
}
