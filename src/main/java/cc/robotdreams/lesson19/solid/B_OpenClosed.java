package cc.robotdreams.lesson19.solid;

public class B_OpenClosed
{
    static abstract public class Human
    {
        abstract String getName();
        abstract String getGender();
    }

    static public class Men extends Human
    {
        @Override
        String getName() {
            return "Male name";
        }

        @Override
        String getGender() {
            return "Male";
        }
    }

    static public class Woman extends Human
    {
        @Override
        String getName() {
            return "Female name";
        }

        @Override
        String getGender() {
            return "Female";
        }
    }

    static public class peopleManager
    {
        public String getGender(Human human) {
            if (human.getClass() == Men.class) {
                return "Male";
            }
            if (human.getClass() == Woman.class) {
                return "Female";
            }
            return "Undefined";
        }
    }
}
