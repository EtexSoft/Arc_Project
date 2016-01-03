package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Андрей on 24.12.2015.
 */
    @Entity
    @Table(name = "Users")
    public class User {
        @Id
        @Column(name = "Login")
        private String login;
        @Column(name = "Password")
        private String password;

        public User() {
        }

        public User(String login, String password) {
            this.login = login;
            this.password = password;
        }

        public String getLogin() {
            return login;
        }

        public void setLogin(String login) {
            this.login = login;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
