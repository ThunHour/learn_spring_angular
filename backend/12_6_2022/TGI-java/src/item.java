public class item {
    public String getName() {
        return name;
    }
    public String getId() {
        return id;
    }
    public String getPic() {
        return pic;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setPic(String pic) {
        this.pic = pic;
    }
    public item(String name, String id, String pic) {
        this.name = name;
        this.id = id;
        this.pic = pic;
    }
    private String name;
    private String id;
    private String pic;


}
