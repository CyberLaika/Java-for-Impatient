package theory.AnotherOne;

public class test {
    public static void main(String[] args) {
        Contacts myContacts= new Contacts();
        myContacts.addContact("Peter the Great", new Contact("+79456551838"));
        myContacts.addContact("Mehmed the Conqueror", new Contact("+90135743852","muhmed2@mail.osman","Constantinople","","" ));
        myContacts.addContact("Devil", new Contact("+666","boiler@mail.hell","Hell","","" ));
        myContacts.addContact("Amoeba", new Contact("+79666971740"));

        myContacts.print();

        myContacts.deleteContact("Devil");

        myContacts.addContact("Noizer",new Contact("+79154316031"));

        System.out.println();

        myContacts.print();
    }
}
