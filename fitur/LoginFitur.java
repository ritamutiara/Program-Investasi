package fitur;

import akun.User;
import java.util.ArrayList;
import java.util.List;

public class LoginFitur {
    private List<User> daftarPengguna;

    public LoginFitur() {
        this.daftarPengguna = new ArrayList<>();
    }

    // Method untuk menambahkan user
    public void tambahPengguna(User user) {
        daftarPengguna.add(user);
    }

    // Method untuk mengelola login
    public User login(String username, String password) {
        for (User user : daftarPengguna) {
            if (user.validasiLogin(username, password)) {
                return user;
            }
        }
        return null;
    }
}