package theory.AnotherOne;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Contacts {

    TreeMap<String,Contact> map;

    public Contacts() {
        this.map = new TreeMap<>();
    }

    public void addContact(String name, Contact info){
        map.put(name, info);
    }

    public void deleteContact(String name){
        map.remove(name);
    }

    public Set<String> getContacts(){
        return map.keySet();
    }

    public Contact getContact(String name){
        return map.get(name);
    }

    public void print(){
        for (Map.Entry<String,Contact> pair : map.entrySet())
        System.out.println(pair.toString());
    }

    public String getName(Contact contact){
        for (Map.Entry<String,Contact> pair : map.entrySet()) {
            if (contact.equals(pair.getValue())) {
                return pair.getKey();// нашли наше значение и возвращаем  ключ
            }
        }
        return null;
    }

    public String getNameWithNumber(String number){
        for (Map.Entry<String,Contact> pair : map.entrySet()) {
            if (number.equals(pair.getValue().getPhoneNumber())) {
                return pair.getKey();
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "{" +
                map +
                '}';
    }
}
