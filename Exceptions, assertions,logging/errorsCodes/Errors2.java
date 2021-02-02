package errorsCodes;

import n4.Errors;

public class Errors2 {
    public enum ErrorCodes{
        InvalidFIleName(-1, "Incorrect File Name"),
        FileNotFound(-2,"File not found"),
        InvalidNumberFormat(-3,"Invalid file number format"),
        Success(1,"Success"),
        Fail(0,"Some problem");

        public int code;
        public String comment;
        ErrorCodes(int code, String comment){
            this.code=code;
            this.comment=comment;
        }
        int getCode(){return this.code;}
        private String getComment(){return this.comment;}

        public static Errors.ErrorCodes0 getEnum(int code){
            for(int i = 0; i< Errors.ErrorCodes0.values().length; i++)
                if(Errors.ErrorCodes0.values()[i].code==code)
                    return Errors.ErrorCodes0.values()[i];
            return null;
        }
    }
}
