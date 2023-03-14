import java.util.Random;
import java.util.function.*;

public class Main {

    public static <T, U> Function<T, U> ternaryOperator(Predicate<? super T> condition, Function<? super T, ? extends U> ifTrue, Function<? super T, ? extends U> ifFalse) {
        return x -> condition.test(x) ? ifTrue.apply(x) : ifFalse.apply(x);
    }

    public static void main(String[] args) {
        task1();
        printLine();
        task2();
        printLine();
        task3();
        printLine();
        task4();
        printLine();
        task5();
    }

    public static void printLine() {
        System.out.println("-----------------");
    }

    public static void task1() {
        System.out.println("Task 1");
        final Random random = new Random();
        int num1 = random.nextInt(101) - random.nextInt(101);
        int num2 = random.nextInt(101) - random.nextInt(101);

        // С помощью анонимного класса
        Predicate<Integer> positiveNum = new Predicate<>() {
            @Override
            public boolean test(Integer integer) {
                return num1 > 0;
            }
        };

        System.out.println("Входное число: " + num1);
        System.out.println("Вывод: " + positiveNum.test(num1));

        // С помощью лямбда-выражения
        Predicate<Integer> positiveNum1 = Integer -> num2 > 0;
        System.out.println("Входное число: " + num2);
        System.out.println("Вывод: " + positiveNum1.test(num2));
    }

    public static void task2() {
        System.out.println("Task 2");
        Person person1 = new Person("Anton");
        Person person2 = new Person("Andrey");

        // С помощью анонимного класса
        Consumer<Person> greetings = new Consumer<Person>() {
            @Override
            public void accept(Person person) {
                System.out.println("Hallo " + person.getName() + "!");
            }
        };
        greetings.accept(person1);

        // С помощью лямбда-выражения
        Consumer<Person> greetengs2 = Person -> System.out.println("Hallo " + person2.getName() + "!");
        greetengs2.accept(person2);
    }

    public static void task3() {
        System.out.println("task 3");
        final Random random = new Random();
        double num1 = random.nextDouble() + random.nextInt(101);
        double num2 = random.nextDouble() + random.nextInt(101);

        // С помощью анонимного класса
        Function<Double, Long> rounding = new Function() {
            @Override
            public Object apply(Object o) {
                return Math.round(num1);
            }
        };
        System.out.println("Входное число: " + num1);
        System.out.println("Вывод: " + rounding.apply(num1));

        // С помощью лямбда-выражения
        Function<Double, Long> rounding2 = Double -> Math.round(num2);
        System.out.println("Входное число: " + num2);
        System.out.println("Вывод: " + rounding2.apply(num2));
    }

    public static void task4() {
        System.out.println("task 4");
        final Random random = new Random();

        // С помощью анонимного класса
        Supplier<Integer> randomNum = new Supplier<>() {
            @Override
            public Integer get() {
                return random.nextInt(101);
            }
        };
        System.out.println("Вывод: " + randomNum.get());

        // С помощью лямбда-выражения
        Supplier<Integer> randomNum2 = () -> random.nextInt(101);
        System.out.println("Вывод: " + randomNum2.get());
    }

    public static void task5() {
        System.out.println("Task 5");
        Random random = new Random();
        int x = random.nextInt(101) - random.nextInt(101);
        System.out.println("Входное число: " + x);
        Predicate<Integer> predicate = Integer -> x > 0;
        Function<Integer, Integer> function1 = Integer -> x + 2;
        Function<Integer, Integer> function2 = Integer -> (int) Math.pow(x, 2);
        System.out.println("Вывод: " + ternaryOperator(predicate, function1, function2).apply(x));
    }
}
