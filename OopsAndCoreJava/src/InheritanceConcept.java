


    class Animal {
        void eat() {
            System.out.println("Animal is eating");
        }

        public void sound() {
            System.out.println("Animal makes a sound");
        }
        void print(){
            System.out.println("is it Animal class");
        }
    }

    class Dog extends Animal {
        void bark() {
            System.out.println("Dog is barking");
        }
        void print(){
            System.out.println("is it Dog class");
        }

        @Override
        public void sound() {
            System.out.println("Dog barks");
        }
    }
    class Parent {
        public String name = "Parent";
        protected int age = 40;
        private double balance = 1000;

        Parent() {
            System.out.println("Parent constructor");
        }

        public double getBalance() {
            return balance;
        }
        static void show() {
            System.out.println("Parent static");
        }

        private void secret() {
            System.out.println("Private method");
        }
    }

    class Child extends Parent {
        Child() {
            super(); // Calls the parent constructor
            System.out.println("Child constructor");
        }

        void display() {
            System.out.println("name " + name);         // Inherited
            System.out.println("age " + age);          // Inherited
            System.out.println(getBalance()); // Inherited method

//             System.out.println(balance);   // Error: private
//             secret();                      // Error: private
        }
        static void show() {
            System.out.println("Parent static");
        }
    }


    public class InheritanceConcept {
        public static void main(String[] args) {



//            Parent child = new Child();
//            child.display();
            Parent obj = new Child();
            obj.show(); // Parent static
//            System.out.println(child.getBalance()); // 1000.0
        }
    }




   /* In Animal animal = new Dog():
            - Reference type: Animal — determines which methods you can call at compile time.
- Actual object type: Dog — determines which overridden implementation runs at runtime.
    This is runtime polymorphism, also called dynamic method dispatch.

    */


    /* static hiding */
    /* Static method hiding happens when a child class declares a static method with
    the same signature as an accessible static method in its parent class.
The child method hides the parent method. It does not override it, because static methods belong to classes.
     */


    /* Field hiding */
    /* Field hiding happens when a child class declares a field with the same name as a field
    in its parent class. The child’s field hides the parent’s field, but both fields still exist.*/
