package FileOperations;

public interface AdminDetailsFileHandlerService {

    boolean containsAdmin(String userName);
    boolean passwordMatches(String userName, String password);
}
