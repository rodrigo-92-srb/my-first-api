package rodrigosrb.myfirstapi.handler;

public class FieldRequiredException extends BusinessException{

    public FieldRequiredException(String field){
        super("%s field is required!", field);
    }

}
