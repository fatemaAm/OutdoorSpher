package com.example.outdoorsphere;

import java.util.ArrayList;
import java.util.List;

public class InformationMockUp {
    private static List<Information> list;

    public InformationMockUp() {


    }
    public static List<Information> getListcycle() {
        list = new ArrayList<>();

        list.add(new Information("Cycling","BIKE RIDES",R.drawable.bik,"Riding a bike allows you to cover greater distances in less time than you could ever achieve on foot, plus you generally need very little in the way of equipment or experience.  In many parts of the world, the increasing popularity of the bike is leading to the development of better cycling networks, which increasingly allow the rider to avoid mingling with vehicular traffic.\n" +
                "The number of routes you can choose from is also growing - as is the variety of experiences they offer. Cycling is no longer simply a matter of getting from A to B  - you can also use your bike to explore hills, lakes, coastlines, and, of course, towns and cities."," Choose the Right Bike for Your Needs \n"+"Safety First: Essential Gear and Equipment"));
        list.add(new Information("Cycling","MOUNT BIKING",R.drawable.bi,"The birth of mountain biking dates back to 1976 on Mount Tamalpais in California when the first downhill races took place on converted bikes from the 1930s. The subsequent and rapid triumph of the mountain bike was fuelled by all kinds of technical innovations and enthusiasm that came from the American outdoor scene, and a new sport soon became known nationwide.\n" +
                "The appeal of mountain biking is obvious to many, with steep climbs and fast descents taking place through a terrain of gravel tracks, technical trails, and jumps that are guaranteed to provide plenty of adrenalin. Both fitness and riding techniques are put to the test when mountain biking, but the sense of fun is also always there. \n","Choose the Right Mountain Bike\n"+" Safety Gear and Essential Equipment"));

        return list;
    }
    public static List<Information> getListRun() {
        list = new ArrayList<>();


        list.add(new Information("Running","RUNNING",R.drawable.run,"Running is one of the most natural and original forms of human locomotion, it was being practiced competitively by the ancient Greeks. Running is a go-to activity for those who want to boost their fitness! It has many benefits including improving endurance and stamina. Continuous, moderate running or jogging increases the general well-being of mind and body."," Start with a Plan\n"+
                "Wear Proper Running Shoes \n"+"Focus on Running Form"));
        list.add(new Information("Running","TRAIL RUNNING",R.drawable.runn,"Trail running is incredibly demanding. Off the beaten track, cross-country over hill and dale. Trail running is rigorous, however, it strengthens a huge variety of muscular groups due to its all encompassing demands. When on trail, the runner must constantly keep their eyes on the ground, which in turn trains coordination and reactions. Overturned trees, streams, scree and sand – what more could you want?","Choose the Right Trail Shoes\n"+"Start Slow and Build Stamina \n"+"Focus on Trail-Specific Running Form"));


        return list;
    }
    public static List<Information> getListMount() {
        list = new ArrayList<>();


        list.add(new Information("Mountaineering","VIA FERRATA",R.drawable.mon,"Via Ferratas offer experienced hikers and those interested in climbing a relatively safe entry into the world of walls, ridges and rocks. Anyone who is familiar with carabiners, has arm strength, a head for heights and a dose of courage can dare to climb spectacular areas that are often breakneck exposed and breathtakingly steep. Find the right via ferrata for you with Outdooractive!","Use the Right Gear \n"+"Understand How to Use the Equipment Safely"));
        list.add(new Information("Mountaineering","ALPINE ROUTE",R.drawable.mun,"High up on the mountain, usually in the early morning hours, the adventure of high altitude touring begins. Often roped up, you'll walk across crevasse-ridden glaciers, hear the snow crunching under your shoes, and climb over ice and rocks as the air gets thinner and thinner. Experience, knowledge and trust in your group are therefore indispensable on a strenuous high-altitude tour. On Outdooractive you can find out what you need to bear in mind on your high-altitude tour","Build Necessary Mountaineering Skills \n"+"Use Specialized Alpine Equipment"));



        return list;
    }
    public static List<Information> getListWinter() {
        list = new ArrayList<>();

        list.add(new Information("Winter Sports","WINTER HIKING",R.drawable.wint,"Well-prepared winter hiking trails lead you across snow-covered meadows, up to glittering mountain peaks and through quiet forests. One or the other hut is also open in winter to provide you with a warm room and tasty refreshments along the way. Walking through the white landscape is a great experience for young and old. Discover the most beautiful winter hikes with Outdooractive!","Dress in Layers for Cold Weather \n"+"Wear Proper Winter Hiking Gear\n"+"Plan and Prepare for Shorter Daylight "));
        list.add(new Information("Winter Sports","SLEDDING",R.drawable.win,"It has been quite a while since the sledge was used as a means of locomotion and transport in winter. Nowadays sledding is both a winter pleasure for the whole family and a popular sport. On this page we will show you the differences between the different types of sledges and also provide you with important information for your sledging trip.","Choose a Safe Sledding Location \n"+"Choose the Right Sled and Equipment\n"+"Practice Safe Sledding Techniques"));

        return list;
    }

    public static List<Information> getList() {
        list = new ArrayList<>();
        list.add(new Information("Hiking", "Hiking Routes", R.drawable.hirot, "Hikes are an assured way to discover a region's scenery, history, culture, and food. Most of the routes in this category cover well-trodden paths and trails in the countryside for which you need little more than just comfortable shoes, suitable clothing, basic provisions, and a camera for capturing the moment. ", "Assess Your Fitness Level and Hiking Experience \n"+" Research the Trail and Weather Conditions"));
        list.add(new Information("Hiking", "Long-Distance Hiking", R.drawable.longs, "Multi-stage hikes can take many forms, from Alpine crossings to guided trips or solo adventures. These regional trails let you tackle your challenge one step at a time. ", " Training and Physical Preparation \n"+" .Route Research and Planning"));

        return list;
    }

    public void setList(List<Information> list) {
        this.list = list;
    }

    public String[] getOutdoorTypes() {
        return new String[]{"Hiking Routes", "Long-Distance Hiking"};
    }
    public String[] getCycleTypes() {
        return new String[]{"BIKE RIDES ", "MOUNT BIKING"};

    }
    public String[] getMountTypes() {
        return new String[]{"VIA FERRATA", "ALPINE ROUTE"};

    }
    public String[] getRunnTypes() {
        return new String[]{"RUNNING","TRAIL RUNNING"};

    }
    public String[] getWinterTypes() {
        return new String[]{"WINTER HIKING ", "SLEDDING"};

    }
    public List<Information> getByType(String Type){
        List<Information> result = new ArrayList<>();
        for(Information d : list){
            if (d.getNametype().equals(Type)){
                result.add(d);
            }
        }
        return result;
    }
}
