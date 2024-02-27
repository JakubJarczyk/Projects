import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import java.util.Random;

public class Game extends JFrame implements Runnable{

    public static int time;

    public static int gameMultiplier;
    public static int gameMultiplier2;

Thread thread = new Thread(this);
Thread thread2 = new Thread(this::firstInfected);


    JLabel mapLabel = new JLabel();

    JLabel timeInfo = new JLabel();
    ImageIcon mapIcon = new ImageIcon("map.png");

    JTextField textField = new JTextField();

Random random = new Random();
        Country usa = new Country("USA", 100000, 70);
        Country brazil = new Country("Brazil", 80000,50);
        Country france = new Country("France", 50000,80);
        Country germany = new Country("Germany", 60000,80);
        Country russia = new Country("Russia", 50000,40);
        Country australia = new Country("Australia", 80000,70);
        Country rpa = new Country("RPA", 50000,60);
        Country marocco = new Country("Marocco", 40000,50);
        Country india = new Country("India", 200000,40);
        Country china = new Country("China", 200000,50);

        JProgressBar usaBar = new JProgressBar(0,usa.getHealthyPeople());
        JProgressBar brazilBar = new JProgressBar(0,brazil.getHealthyPeople());
        JProgressBar franceBar = new JProgressBar(0,france.getHealthyPeople());
        JProgressBar germanyBar = new JProgressBar(0,germany.getHealthyPeople());
        JProgressBar russiaBar = new JProgressBar(0,russia.getHealthyPeople());
        JProgressBar australiaBar = new JProgressBar(0,australia.getHealthyPeople());
        JProgressBar rpaBar = new JProgressBar(0,rpa.getHealthyPeople());
        JProgressBar maroccoBar = new JProgressBar(0,marocco.getHealthyPeople());
        JProgressBar indiaBar = new JProgressBar(0,india.getHealthyPeople());
        JProgressBar chinaBar = new JProgressBar(0,china.getHealthyPeople());

        Country[] usaBC = {brazil,france,marocco,rpa,china,australia};
    Country[] brazilBC = {usa,france,rpa};
    Country[] franceBC = {germany,russia,usa,marocco,india};
    Country[] germanyBC = {usa,brazil,france,marocco,india};
        Country[] russiaBC = {germany,france,china,india,australia};
        Country[] australiaBC = {usa,russia,china,india,rpa};
        Country[] rpaBC = {usa,brazil,australia,india};
        Country[] maroccoBC = {germany,france,russia};
        Country[] indiaBC = {germany,russia,china};
        Country[] chinaBC = {india,australia,russia,marocco};


        JLabel usaLabel = new JLabel("USA");
        JLabel brazilLabel = new JLabel("BRAZIL");
        JLabel franceLabel = new JLabel("FRANCE");
        JLabel germanyLabel = new JLabel("GERMANY");
        JLabel russiaLabel = new JLabel("RUSSIA");
        JLabel australiaLabel = new JLabel("AUSTRALIA");
        JLabel rpaLabel = new JLabel("RPA");
        JLabel maroccoLabel = new JLabel("MAROCCO");
        JLabel indiaLabel = new JLabel("INDIA");
        JLabel chinaLabel = new JLabel("CHINA");


    Country[] countries = {usa,brazil,france,germany,russia,australia,rpa,marocco,india,china};

    JComboBox countriesBox;

    JButton firstFuncButton = new JButton("Vaccinations");
    JButton secondFuncButton = new JButton("Block the border");

   static int points = 1000;
    int price1 = 1000;
    int price2 = 10000;

    JLabel pointsLabel = new JLabel();
    JLabel firstPriceLabel = new JLabel();
    JLabel secondPriceLabel = new JLabel();

   Thread flyUsa = new Thread(()->{
flights(usa);
   });
Thread flyBrazil = new Thread(()->{
    flights(brazil);
});
    Thread flyFrance = new Thread(()->{
        flights(france);
    });
    Thread flyGermany = new Thread(()->{
        flights(germany);
    });
    Thread flyRussia = new Thread(()->{
        flights(russia);
    });
    Thread flyAustralia = new Thread(()->{
        flights(australia);
    });
    Thread flyRpa = new Thread(()->{
        flights(rpa);
    });
    Thread flyMarocco = new Thread(()->{
        flights(marocco);
    });
    Thread flyIndia = new Thread(()->{
        flights(india);
    });
    Thread flyChina = new Thread(()->{
        flights(china);
    });
ImageIcon planeIcon;
JLabel planeLabel = new JLabel(planeIcon);

    Thread flyThread;
    Game(){
        usa.borderCountries = usaBC;
        brazil.borderCountries = brazilBC;
        france.borderCountries = franceBC;
        germany.borderCountries = germanyBC;
        russia.borderCountries = russiaBC;
        australia.borderCountries = australiaBC;
        rpa.borderCountries = rpaBC;
        marocco.borderCountries = maroccoBC;
        india.borderCountries = indiaBC;
        china.borderCountries = chinaBC;

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(830, 600);
        setLayout(null);
        getContentPane().setBackground(Color.darkGray);
        setLocationRelativeTo(null);



        timeInfo.setBounds(740,10,80,20);
        timeInfo.setForeground(Color.RED);

        add(timeInfo);

        textField.setBounds(250,10,480,20);
        textField.setEditable(false);
        add(textField);

        usaBar.setBounds(80,65,150,30);
        usaBar.setValue(usa.getHealthyPeople());
        usaBar.setBackground(Color.RED);
        usaBar.setForeground(Color.green);
        add(usaBar);
        usa.progressBar = usaBar;

        brazilBar.setBounds(80,100,150,30);
        brazilBar.setValue(brazil.getHealthyPeople());
        brazilBar.setBackground(Color.RED);
        brazilBar.setForeground(Color.green);
        add(brazilBar);
        brazil.progressBar = brazilBar;

        franceBar.setBounds(80,135,150,30);
        franceBar.setValue(france.getHealthyPeople());
        franceBar.setBackground(Color.RED);
        franceBar.setForeground(Color.green);
        add(franceBar);
        france.progressBar = franceBar;

        germanyBar.setBounds(80,170,150,30);
        germanyBar.setValue(germany.getHealthyPeople());
        germanyBar.setBackground(Color.RED);
        germanyBar.setForeground(Color.green);
        add(germanyBar);
        germany.progressBar = germanyBar;

        russiaBar.setBounds(80,205,150,30);
        russiaBar.setValue(russia.getHealthyPeople());
        russiaBar.setBackground(Color.RED);
        russiaBar.setForeground(Color.green);
        add(russiaBar);
        russia.progressBar = russiaBar;

        australiaBar.setBounds(80,240,150,30);
        australiaBar.setValue(australia.getHealthyPeople());
        australiaBar.setBackground(Color.RED);
        australiaBar.setForeground(Color.green);
        add(australiaBar);
        australia.progressBar = australiaBar;

        rpaBar.setBounds(80,30,150,30);
        rpaBar.setValue(rpa.getHealthyPeople());
        rpaBar.setBackground(Color.RED);
        rpaBar.setForeground(Color.green);
        add(rpaBar);
        rpa.progressBar = rpaBar;

        maroccoBar.setBounds(80,275,150,30);
        maroccoBar.setValue(marocco.getHealthyPeople());
        maroccoBar.setBackground(Color.RED);
        maroccoBar.setForeground(Color.green);
        add(maroccoBar);
        marocco.progressBar = maroccoBar;

        indiaBar.setBounds(80,310,150,30);
        indiaBar.setValue(india.getHealthyPeople());
        indiaBar.setBackground(Color.RED);
        indiaBar.setForeground(Color.green);
        add(indiaBar);
        india.progressBar = indiaBar;

        chinaBar.setBounds(80,345,150,30);
        chinaBar.setValue(china.getHealthyPeople());
        chinaBar.setBackground(Color.RED);
        chinaBar.setForeground(Color.green);
        add(chinaBar);
        china.progressBar = chinaBar;

        rpaLabel.setForeground(Color.ORANGE);
        rpaLabel.setBounds(50,30,40,30);
        add(rpaLabel);

        usaLabel.setForeground(Color.ORANGE);
        usaLabel.setBounds(50,65,40,30);
        add(usaLabel);

        brazilLabel.setForeground(Color.ORANGE);
        brazilLabel.setBounds(35,100,80,30);
        add(brazilLabel);

        franceLabel.setForeground(Color.ORANGE);
        franceLabel.setBounds(25,135,80,30);
        add(franceLabel);

        germanyLabel.setForeground(Color.ORANGE);
        germanyLabel.setBounds(15,170,80,30);
        add(germanyLabel);

        russiaLabel.setForeground(Color.ORANGE);
        russiaLabel.setBounds(30,205,80,30);
        add(russiaLabel);

        australiaLabel.setForeground(Color.ORANGE);
        australiaLabel.setBounds(10,240,80,30);
        add(australiaLabel);

        maroccoLabel.setForeground(Color.ORANGE);
        maroccoLabel.setBounds(15,275,80,30);
        add(maroccoLabel);

        indiaLabel.setForeground(Color.ORANGE);
        indiaLabel.setBounds(45,310,80,30);
        add(indiaLabel);

        chinaLabel.setForeground(Color.ORANGE);
        chinaLabel.setBounds(40,345,80,30);
        add(chinaLabel);
        final Country[] country = new Country[1];
        String[] arrayOfCountries = {"USA","Brazil","France", "Germany", "Russia", "Australia", "RPA","Marocco","India","China"};
        countriesBox = new JComboBox(arrayOfCountries);
        countriesBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                {
                    JComboBox cb = (JComboBox) e.getSource();
                    String msg = (String) cb.getSelectedItem();

                    for (Country countryEach : countries) {
                        if (countryEach.getNazwa().equals(msg)) {
                            country[0] = countryEach;
                        }
                    }
                    assert country[0] != null;
                    if (country[0].toBlock() && points >= price2 && !country[0].isClosedBorders()) {
                        secondFuncButton.setEnabled(true);
                    } else {
                        secondFuncButton.setEnabled(false);
                    }
                    if (points < price1 || country[0].getMultiplier()==0) {
                        firstFuncButton.setEnabled(false);
                    } else {
                        firstFuncButton.setEnabled(true);
                    }
                    secondPriceLabel.setText("price: " + price2 + ", " + country[0].getPercentage()+ "%");
                }
            }
        });
        countriesBox.setBounds(250,400,120,50);
        add(countriesBox);

        firstFuncButton.setBounds(375,400,120,50);
        firstFuncButton.setEnabled(false);
        firstFuncButton.addActionListener(e -> {
            points -= price1;
            pointsLabel.setText("Points: "+ points);
            if (points < price1 || country[0].getMultiplier()==0) {
                firstFuncButton.setEnabled(false);
            } else {
                firstFuncButton.setEnabled(true);
            }
country[0].setCure(country[0].getCure()+gameMultiplier2);
            price1 += 500;
            country[0].setLvl(country[0].getLvl()+1);
            country[0].progressBar.setString("vaccinations " + country[0].getCure()+"/s");
            country[0].progressBar.setStringPainted(true);
            firstPriceLabel.setText("price: " + price1);
        });
        add(firstFuncButton);

        secondFuncButton.setBounds(500,400,140,50);
        secondFuncButton.setEnabled(false);
        secondFuncButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

country[0].setClosedBorders(true);
points -= price2;
String wiadomosc = country[0].getNazwa() + " closes its borders!";
wyswietlanie(wiadomosc);
country[0].progressBar.setForeground(Color.orange);
                pointsLabel.setText("Points: "+ points);
                if (country[0].toBlock() && points >= price2 && !country[0].isClosedBorders()) {
                    secondFuncButton.setEnabled(true);
                } else {
                    secondFuncButton.setEnabled(false);
                }
            }
        });
        add(secondFuncButton);

pointsLabel.setText("Points: "+ points);
pointsLabel.setForeground(Color.green);
pointsLabel.setFont(new Font("MV Boli", Font.PLAIN,20));
pointsLabel.setBounds(100,400,150,30);
add(pointsLabel);

firstPriceLabel.setBounds(380,450,150,20);
        firstPriceLabel.setFont(new Font("MV Boli", Font.PLAIN,15));
       firstPriceLabel.setForeground(Color.yellow);
       firstPriceLabel.setText("price: " + price1);
       add(firstPriceLabel);

secondPriceLabel.setBounds(500,450,200,20);
        secondPriceLabel.setFont(new Font("MV Boli", Font.PLAIN,15));
        secondPriceLabel.setForeground(Color.yellow);
        secondPriceLabel.setText("price: " + price2);
        add(secondPriceLabel);

thread.start();
thread2.start();

flyUsa.start();
flyBrazil.start();
flyFrance.start();
flyGermany.start();
flyRussia.start();
flyAustralia.start();
flyRpa.start();
flyMarocco.start();
flyIndia.start();
flyChina.start();

        planeIcon = new ImageIcon("smallplane.png");
planeLabel.setBounds(0,0,40,40);
add(planeLabel);


        mapLabel.setIcon(mapIcon);
        mapLabel.setBounds(250,40,550,336);
        add(mapLabel);
//remove(usaPlane);
        //usaPlane.setVisible(false);
    }
    void flying(){
        int randomX = randomNumb(300,400);
        int randomY = randomNumb(80,300);
        int randomSide = randomNumb(0,1);
        int randomOsY = randomNumb(0,1);
        int osY = 0;
        if(randomOsY == 1) {
           osY = 1;
        }else{
            osY = -1;
        }
        if(randomSide==0) {
            planeIcon = new ImageIcon("smallplane.png");
            planeLabel = new JLabel(planeIcon);
            add(planeLabel);
            for (int i = 0; i < 20; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                planeLabel.setBounds(randomX+5,randomY+osY,40,40);
            }
        }else{
            planeIcon = new ImageIcon("smallplane2.png");
            planeLabel = new JLabel(planeIcon);
            add(planeLabel);
            for (int i = 0; i < 20; i++) {
                planeLabel.setBounds(randomX-5,randomY+osY,40,40);
            }
        }
        planeLabel.setVisible(false);
    }


    int sec = 0;
    int min = 0;
void timer(int x){
    sec ++;
        if(x%60 == 0){
            min++;
            sec = 0;
        }
    timeInfo.setText("Time: " + min +":"+ sec);
}

 int randomNumb(int border1, int border2){
    int helper;
    helper = random.nextInt(border2)+border1;
    return helper;
}

void wyswietlanie (String tekst) {
   StringBuilder stringBuilder = new StringBuilder();
    for (int i = tekst.length()-1; i >= 0; i--) {
       stringBuilder.insert(0,tekst.charAt(i));
        textField.setText(stringBuilder.toString());
        try {
            Thread.sleep(30);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    for (int i = 0; i < 160; i++) {
        stringBuilder.insert(0," ");
        textField.setText(stringBuilder.toString());
        try {
            Thread.sleep(30);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
textField.setText("");
}

void firstInfected(){
    Country first;
    first = countries[randomNumb(0,countries.length-1)];
    first.setMultiplier(gameMultiplier);
String wiadomosc = first.getNazwa() + " is infected!";
wyswietlanie(wiadomosc);
}

void zarazanie(Country country){
    country.setHealthyPeople(country.getHealthyPeople()-country.getMultiplier()+country.getCure());
    country.setSickPeople(country.getSickPeople()+country.getMultiplier());
    country.progressBar.setValue(country.getHealthyPeople());
    points+=country.getCure();
}

void flights(Country baseCountry) {
    while (true) {
        int randomValue;
        randomValue = randomNumb(5, 20);
        for (int i = 0; i < randomValue - 1; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        Country randomCountry;

        randomCountry = baseCountry.borderCountries[randomNumb(0, baseCountry.borderCountries.length - 1)];
        if (!randomCountry.isClosedBorders()) {
/*flyThread = new Thread(this::flying);
flyThread.start();*/
            int infected = baseCountry.getPopulation() - baseCountry.getHealthyPeople();
            float percentageMet = (float) infected / baseCountry.getPopulation() * 100;
            int randomNumb = randomNumb(0, 100);
            if (baseCountry.getMultiplier() != 0) {
                if (percentageMet >= randomNumb) {
                    randomCountry.setMultiplier(randomCountry.getMultiplier() + gameMultiplier);
                    String wiadomosc = randomCountry.getNazwa() + " is now infected!";
                    wyswietlanie(wiadomosc);
                    System.out.println(randomCountry.getNazwa() + " INFECTED!!!");
                }
            }
            System.out.println("lot z " + baseCountry.getNazwa() + " do " + randomCountry.getNazwa());
        }else{
            System.out.println("Lot " + baseCountry.getNazwa() + " - "+randomCountry.getNazwa() + " ZABLOKOWANY!!!");
        }
    }
}


    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            time++;
           timer(time);
           zarazanie(usa);
           zarazanie(brazil);
           zarazanie(france);
           zarazanie(germany);
           zarazanie(russia);
           zarazanie(australia);
           zarazanie(rpa);
           zarazanie(marocco);
           zarazanie(india);
           zarazanie(china);
            pointsLabel.setText("Points: "+ points);


        }

    }
}
