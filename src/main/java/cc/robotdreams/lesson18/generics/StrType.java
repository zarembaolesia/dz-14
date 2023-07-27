package cc.robotdreams.lesson18.generics;

public class StrType extends Type<String>
{
    public StrType(String value) {
        super(value);
    }

    @Override
    public void add(String value) {
        checkNotNull(value);
        this.value += " + " + value;
    }
}
