package cat.dam.ivan.activity_en_memoria;

import android.util.Log;

import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    private String name;

    public MainViewModel() {
        Log.i("ViewModel", "ViewModel is created");
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    @Override protected void onCleared() {
        super.onCleared();
        Log.i("ViewModel","ViewModel will be destroyed!. Save data:"+name);
//        At minimum, it would be the cases where onDestroy() on an Activity
//        or onCleared on ViewModel is not executed. That includes:
//        An unhandled exception
//        The user clicking "Force Stop" on your app's screen in the Settings app
//        Some cases where the system terminates your process in the background
//        (specifically, where the need for system RAM is urgent,
//        such as to handle an incoming call,
//        and your app's process "draws short straw" to be terminated)
//        So, usually onCleared() is called, but it is not guaranteed.
    }
}
