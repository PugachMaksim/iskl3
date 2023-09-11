package task_3;

import task_3.Exceptions.UserEx;

public interface UserReader {

    User readUser() throws UserEx;
}