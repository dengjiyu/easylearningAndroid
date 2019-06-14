package djy.login;

import cn.bmob.v3.BmobUser;

/**
 * Created by Administrator on 2016/4/24 0024.
 */
public class Login_Password extends BmobUser {
    private String name;
    private int age;
    private String adress;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }


}
