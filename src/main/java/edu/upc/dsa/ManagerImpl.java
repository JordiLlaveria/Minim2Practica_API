package edu.upc.dsa;

import java.util.LinkedList;

public class ManagerImpl implements Manager {

    Badge masjugon = new Badge("El más jugón","http://localhost:8080/public/jugon.png");
    Badge maslento = new Badge("El más lento","http://localhost:8080/public/lento.png");
    Badge masepico = new Badge("El más épico","http://localhost:8080/public/epico.png");
    Badge massostenible = new Badge("El más sostenible","http://localhost:8080/public/sostenible.png");
    Badge maslegendario = new Badge("El más legendario","http://localhost:8080/public/legendario.png");
    Badge masmeteorico = new Badge("El más meteórico","http://localhost:8080/public/meteorico.png");

    private static ManagerImpl instance;
    public ManagerImpl(){}
    public static ManagerImpl getInstance(){
        if (instance==null){
            instance = new ManagerImpl();
        }
        return instance;
    }

    LinkedList<Badge> badges = new LinkedList<Badge>();
    LinkedList<User> users = new LinkedList<User>();
    @Override
    public LinkedList<Badge> getBadges() {

        badges.add(masjugon);
        badges.add(maslento);
        badges.add(masepico);
        badges.add(massostenible);
        badges.add(maslegendario);
        badges.add(masmeteorico);
        return badges;
    }

    @Override
    public User getUser(String userId) {
        LinkedList<Badge> badgesjordi = new LinkedList<Badge>();
        badgesjordi.add(masjugon);
        badgesjordi.add(massostenible);
        badgesjordi.add(maslegendario);
        User Jordi = new User("JordiLlaveria","Jordi","http://localhost:8080/public/jordi.png","Llaveria",badgesjordi);
        users.add(Jordi);
        LinkedList<Badge> badgestoni = new LinkedList<Badge>();
        badgestoni.add(masepico);
        User Toni = new User("Toni", "Toni", "http://localhost:8080/public/toni.png", "",badgestoni);
        users.add(Toni);

        int i=0;
        int result=0;
        while (i<users.size()){
            if (users.get(i).getName().equals(userId))
                result = i;
            i++;
        }

        return users.get(result);
    }
}
