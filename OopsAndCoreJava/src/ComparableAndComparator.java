import java.util.*;




    class Admin implements Comparable<Admin>{
        public int id;
        public String name;
        public long salary;

        public Admin(int id,String name,long salary){
            this.id = id;
            this.name=name;
            this.salary= salary;
        }

        public String getName() {
            return name;
        }

        public double getSalary() {
            return salary;
        }

        @Override

        public int compareTo(Admin other){
            return Double.compare(this.salary,other.salary);
        }
        @Override
        public String toString() {
            return name + " : " + salary;
        }
        @Override
        public boolean equals(Object obj) {

            // Same object? Definitely equal.
            if (this == obj) {
                return true;
            }

            // Null or a different class? Not equal.
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }

            // Convert the reference so we can access Admin fields.
            Admin other = (Admin) obj;

            // Our equality rule: same Admin ID.
            return this.id == other.id;
        }

        @Override
        public int hashCode() {
            // Same ID must produce the same hash code.
            return Integer.hashCode(id);
        }
    }
public class ComparableAndComparator {

    public static void main(String [] args){
        List<Admin> Admins=new ArrayList<>(Arrays.asList(
                new Admin(1,"Rahul", 70000),
                new Admin(2,"Priya", 50000),
                new Admin(3,"Amit", 70000),
                new Admin(4,"Neha", 60000)
        ));


        Collections.sort(Admins);
        Admins.forEach(System.out::println);
        // Explicit comparison between two Admins
        Admins.sort((e1, e2) ->
                Double.compare(e1.getSalary(), e2.getSalary())
        );

// Shorter version
        Admins.sort(
                Comparator.comparingDouble(Admin::getSalary)
        );

        // 1. Name ascending
        Comparator<Admin> byName =
                Comparator.comparing(Admin::getName);

// 2. Salary ascending
        Comparator<Admin> bySalary =
                Comparator.comparingDouble(Admin::getSalary);

// 3. Salary descending
        Comparator<Admin> salaryDescending =
                bySalary.reversed();

// 4. Salary ascending, then name ascending for equal salaries
        Comparator<Admin> salaryThenName =
                bySalary.thenComparing(Admin::getName);

// 5. Null Admin objects last, remaining Admins sorted by salary
        Comparator<Admin> nullSafeSalary =
                Comparator.nullsLast(bySalary);

// Apply any rule:
        Admins.sort(salaryThenName);


    }


}


/*
System.out.println(Admin);
System.out.println(Admin.toString());

Both print something like:
Admin@5acf9800

The default format is:
getClass().getName() + "@" + Integer.toHexString(hashCode())

- Admin → class name, including its package if applicable.
- @ → separator.
- 5acf9800 → the object's hash code in hexadecimal, not a memory address.
 */



/*

| Purpose | Method | Example |
|---|---|---|
| Start with a String or another comparable value | `comparing()` | `Comparator.comparing(Employee::getName)` |
| Start with an `int` | `comparingInt()` | `Comparator.comparingInt(Employee::getAge)` |
| Start with a `long` | `comparingLong()` | `Comparator.comparingLong(Employee::getId)` |
| Start with a `double` | `comparingDouble()` | `Comparator.comparingDouble(Employee::getSalary)` |
| Break a tie using a String or another value | `thenComparing()` | `.thenComparing(Employee::getName)` |
| Break a tie using an `int` | `thenComparingInt()` | `.thenComparingInt(Employee::getAge)` |
| Break a tie using a `long` | `thenComparingLong()` | `.thenComparingLong(Employee::getId)` |
| Break a tie using a `double` | `thenComparingDouble()` | `.thenComparingDouble(Employee::getSalary)` |
| Reverse the existing rule | `reversed()` | `.reversed()` |
 */