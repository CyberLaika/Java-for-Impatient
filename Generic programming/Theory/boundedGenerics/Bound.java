package Theory.boundedGenerics;


import java.lang.reflect.*;
import java.util.Collections;
import java.util.List;

public class Bound {

    public static String genericBounds(Method method){
        StringBuilder str = new StringBuilder();
        TypeVariable<Method>[] vars = method.getTypeParameters();
        Type[] bounds = vars[0].getBounds();
        if(bounds[0] instanceof ParameterizedType){
            ParameterizedType p =(ParameterizedType) bounds[0];
            Type[] typeArguments = p.getActualTypeArguments();
            if(typeArguments[0] instanceof WildcardType){
                WildcardType t= (WildcardType) typeArguments[0];
                Type [] up = t.getUpperBounds();
                Type [] low= t.getLowerBounds();
                if(up.length>0)
                    str.append("Up:").append(up[0].getTypeName());
                if(low.length>0)
                    str.append("Low:").append(low[0].getTypeName());
            }
        }
        return str.toString();
    }



    public static String genericBounds2(Method m) {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        Type[] paramTypes = m.getGenericParameterTypes();
        for (Type t : paramTypes) {
            sb.append(t.getTypeName());
        }
        sb.append(")");
        return sb.toString();
    }



    public static  void  method(List<? super String> list){}

    public static void method(String list){}

    public static void main(String[] args) throws NoSuchMethodException {
       // System.out.println(genericBounds(Bound.class.getMethod("method",List.class)));
        System.out.println(genericBounds2(Bound.class.getMethod("method",List.class)));
       // Collections.sort();
    }
}



