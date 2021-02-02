package n4;

public class Errors {
    public enum ErrorCodes0 {
        InvalidFIleName(-1, "Incorrect File Name"),
        FileNotFound(-2,"File mot found"),
        IllegalState(-3,"Scanner is closed"),
        Success(1,"Success"),
        Fail(0,"Some problem");

        public int code;
        public String comment;
        private ErrorCodes0(int code, String comment){
            this.code=code;
            this.comment=comment;
        }
        int getCode(){return this.code;}
        private String getComment(){return this.comment;}

        public static ErrorCodes0 getEnum(int code){
            for(int i = 0; i< ErrorCodes0.values().length; i++)
                if(ErrorCodes0.values()[i].code==code)
                    return ErrorCodes0.values()[i];
                return null;
        }
    }
}
