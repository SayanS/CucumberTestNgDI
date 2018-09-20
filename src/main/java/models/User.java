package models;

import java.util.HashSet;
import java.util.Set;

public class User {
    private String login;
    private String password;
    private Set<String> skills;

    public User(String login, String password, Set<String> skills){
        this.login=login;
        this.password=password;
        this.skills=skills;
    }

    public User(){
       // this.skills=new HashSet<String>();
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getSkills() {
        return skills;
    }

    public void setSkills(Set<String> skills) {
        this.skills = skills;
    }

    public void addSkill(String skill){
        if(skills==null){
            this.skills=new HashSet<>();
        }
        this.skills.add(skill);
    }
}
