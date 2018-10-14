package draft.test_lambda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toList;

/**
 * Примеры для фич java 8
 *
 * */
public class Main {
    public static void main(String[] args) throws IOException {
        //1
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,9);

        System.out.println(sumAll(list,integer -> true));
        System.out.println(sumAll(list,integer -> integer%2==0));
        System.out.println(sumAll(list,integer -> integer>3));
        //2
        Runnable r = ()->System.out.println("Hello World");
        process(r);
        process(()->System.out.println("Hello World Again..."));
        System.out.println(processFile());
        String res = processFileWithLambda((BufferedReader reader)->reader.readLine());
        String res2 = processFileWithLambda(BufferedReader::readLine);
        System.out.println(res);
        System.out.println(res2);
        //------------------------------------------------------
        //Predicate, Consumer - стандартные инерфейсы в java 8
        //------------------------------------------------------
        //Predicate
        Predicate<String> p = (String s)->s.equals("mandarin") || s.equals("java");
        List<String> listP = Arrays.asList("artem","mandarin","java","cobol");
        List<String> lP = filter(listP,p);
        lP.forEach(System.out::println);
        //Consumer 
        System.out.println("Consumer---->");
        forEach(listP,(String s)->System.out.println(s));
        //Function - такая же фигня
        System.out.println("Function---->");
        Function<Integer,Integer> s = x->x+1;
        Function<Integer,Integer> m = x->x*x;
        Function<Integer,Integer> h = s.andThen(m);
        System.out.println(h.apply(5));

        Function<Integer,Integer> s2 = x->x+1;
        Function<Integer,Integer> m2 = x->x*x;
        Function<Integer,Integer> h2 = s2.compose(m2);
        System.out.println(h2.apply(5));

        //Пример с Apple
        List<Apple> apples = new ArrayList<>();
        apples.add(new Apple(100,"Russia"));
        apples.add(new Apple(10,"USA"));
        apples.add(new Apple(90,"Brazil"));
        apples.add(new Apple(50,"Ukrain"));
        apples.add(new Apple(50,"China"));


        apples.sort((a1,a2)->a1.getWeight().compareTo(a2.getWeight()));
        forEach(apples,(apple)->System.out.println(apple.getWeight()));
        apples.sort(Comparator.comparing(Apple::getWeight)); //comparing это статический метод
        apples.sort(Comparator.comparing(Apple::getWeight).reversed()); //перевернули список
        forEach(apples,(apple)->System.out.println(apple.getWeight()));
        //В случае если веса будут равны можно повесить еще один компаратор
        apples.sort(Comparator.comparing(Apple::getWeight)
                .thenComparing(Apple::getCountry));
        forEach(apples,(apple)->System.out.println(apple.getWeight()+"  "+apple.getCountry()));

        //Stream
        List<Dish> menu = new ArrayList<>();
        menu.add(new Dish(100,"10",true));
        menu.add(new Dish(4000,"20",true));
        menu.add(new Dish(200,"30",false));
        menu.add(new Dish(40,"40",true));

        List<String> listFromMenu = menu.stream()
                .filter(dish -> dish.getCalories()>=200)
                .sorted(Comparator.comparing(Dish::getCalories))
                .map(Dish::getName).collect(toList());
        forEach(listFromMenu,System.out::println);

        //Stream filtering
        List<Dish> vegetarianMenu = menu.stream()
                .filter(Dish::getVegetarian)
                .collect(toList());

        System.out.println("stream distinct---->");
        List<Integer> numbers = Arrays.asList(1,2,3,3,3,2,4,5);
        numbers.stream().filter((num)->num%2==0)
                .distinct()
                .forEach(System.out::println);
        //так же можно пропускать элементы skip() и ограничивать вывод limit()
        //mapping так же как и в sql ты можешь выбрать только одну колонку из таблицы так и тут
        List<String> names = menu.stream()
                .map(Dish::getName)
                .collect(toList());

        //можно мапить замапенное)
        List<Integer> length = menu.stream()
                .map(Dish::getName)
                .map(String::length)
                .collect(toList());

        //flatting map

        List<String> words = Arrays.asList("Hello","World");
        List<String[]> someList = words.stream().map(word->word.split("")).collect(toList());
        someList.forEach((mas)->{// в someList два стринговых массива
            System.out.println("----");
            forEach(Arrays.asList(mas),System.out::println);
        });
        System.out.println("flatMap");
        words.stream()
                .map(word->word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(toList())
                .forEach(System.out::println);

        List<Integer> notSq = Arrays.asList(1,2,3,4,5);
        notSq.stream()
                .map(num->num*num)
                .collect(toList())
                .forEach(System.out::println);
        //reduce
        List<Integer> numbers2 = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Integer sum = numbers2.stream().reduce(0,(a,b)-> a+b);
        System.out.println("Reduce--->\n"+sum);

        //tasks
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
        //1
        transactions.stream()
                .filter(transaction -> transaction.getYear()==2011)
                .sorted(Comparator.comparing(transaction -> transaction.getValue()))
                .forEach(System.out::println);
        //2 city
        transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .forEach(System.out::println);
        //3 from cambridg and sorted by name
        transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .map(transaction -> transaction.getTrader().getName())
                .sorted(Comparator.comparing(s1 -> s1.charAt(0)))
                .forEach(System.out::println);
        //4 the same like 3
        //5
        boolean isMilan = transactions.stream()
                .anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));
        System.out.println(isMilan);
        //6
        transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .map(transaction -> transaction.getValue())
                .forEach(System.out::println);
        //7
        Optional<Integer> maxValue = transactions.stream()
                .map(transaction -> transaction.getValue())
                .reduce((x,y)->x>y?x:y);
        System.out.println("max = "+maxValue.get());
    }



    public static class Trader{
        private final String name;
        private final String city;
        public Trader(String n, String c){
            this.name = n;
            this.city = c;
        }
        public String getName(){
            return this.name;
        }
        public String getCity(){
            return this.city;
        }
        public String toString(){
            return "Trader:"+this.name + " in " + this.city;
        }
    }
    public static class Transaction{
        private final Trader trader;
        private final int year;
        private final int value;
        public Transaction(Trader trader, int year, int value){
            this.trader = trader;
            this.year = year;
            this.value = value;
        }
        public Trader getTrader(){
            return this.trader;
        }
        public int getYear(){
            return this.year;
        }
        public int getValue(){
            return this.value;
        }
        public String toString(){
            return "{" + this.trader + ", " +
                    "year: "+this.year+", " +
                    "value:" + this.value +"}";
        }
    }

    private static class Dish{
        Integer calories;
        String name;
        Boolean isVegetarian;

        public Dish(Integer calories, String name, Boolean isVegetarian) {
            this.calories = calories;
            this.name = name;
            this.isVegetarian = isVegetarian;
        }

        public Boolean getVegetarian() {
            return isVegetarian;
        }

        public void setVegetarian(Boolean vegetarian) {
            isVegetarian = vegetarian;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getCalories() {
            return calories;
        }

        public void setCalories(Integer calories) {
            this.calories = calories;
        }
    }


    public static <T> void forEach(List<T> list, Consumer<T> c){
        for(T t:list){
            c.accept(t);
        }
    }

    public static int sumAll(List<Integer> numbers, Predicate<Integer> p){
        int totalSum = 0;
        for(Integer i : numbers){
            if(p.test(i)){
                totalSum+=i;
            }
        }
        return totalSum;
    }

    public static void process(Runnable r){
        r.run();
    }

    public static String processFile() throws IOException {
        try(BufferedReader reader = new BufferedReader(new FileReader("D:\\test1.txt"))){
            return reader.readLine();
        }
    }
    public static String processFileWithLambda(BufferedReaderProcessor readerProcessor) throws IOException {
        try(BufferedReader reader = new BufferedReader(new FileReader("D:\\test1.txt"))){
            return readerProcessor.process(reader);
        }
    }
    public static <T> List<T> filter(List<T> list, Predicate<T> p){
        List<T> res = new ArrayList<>();
        for(T s:list){
            if(p.test(s)){
                res.add(s);
            }
        }
        return res;
    }

}
