package northwindProject.demo.core.utilities.results;

public
class ErrorDataResult<T> extends DataResult<T>{

    public
    ErrorDataResult ( boolean success, T data ) {
        super ( success, data );
    }

    public
    ErrorDataResult (  String message, T data ) {
        super ( false,message, data );
    }
}
