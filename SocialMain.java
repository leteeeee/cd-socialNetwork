package com.campusdual.social_network;

import javax.xml.stream.events.Comment;
import java.util.*;


// clase con el método main donde se ejecutarán todos los métodos
public class SocialMain {

    private List<User> socialUsers = new ArrayList<>();
    private User activeUser;

    //getter y setters

    public List<User> getSocialUsers() {
        return socialUsers;
    }
    public User getActiveUser() {
        return activeUser;
    }
    public void setActiveUser(User activeUser) {
        this.activeUser = activeUser;
    }
// métodos para acceder a los menús
    public void mainMenu() {
        int option;
        do {
            System.out.println("**********************************");
            System.out.println("Bienvenido a tu red social");
            System.out.println("***********************************");
            System.out.println("Elige una opción: ");
            System.out.println("1. Registrarse");
            System.out.println("2. Loguearse");
            System.out.println("0. Salir");
            option = Utils.integer("Seleccione la opción: ");
            switch (option) {
                case 1:
                    this.register();
                    break;
                case 2:
                    this.login();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Introduce una opción válida");
            }
        } while (option != 0);
        System.out.println("Se ha cerrado la aplicación");
    }

    public void register() {
        String name = Utils.string("Crea tu nombre de usuario: ");
        User user = new User(name);
        this.socialUsers.add(user);
        System.out.println("Te has registrado correctamente con el nombre: " + name);
        this.login();
    }

    public void login() {
        String name = Utils.string("Introduce el nombre de usuario: ");

        // bucle para recorrer la lista Social User, en la variable u se guarda cada elemento de
        // la lista, en el condicional obtenemos el nombre de cada elemento de la lista (u
        // .getName()) y y lo comparamos con name, si el nombre está en la lista lo guardamos en
        // la variable activeUser para saber que usuario está conectado en ese momento

        // array.get(posición) --- para obtener el valor del array en cada posición.
        for (int i = 0; i < this.getSocialUsers().size(); i++) {
            User u = this.getSocialUsers().get(i);
            if (u.getName().equals(name)) {
                this.setActiveUser(u);
                break;
            }
        }
        // si hay algún valor en Active user llévame al menú de login, si no muestra un mensaje
        if (this.getActiveUser() != null) {
            System.out.println("te has logueado correctamente con el nombre: " + this.getActiveUser());
            this.optionsMenu();
        } else {
            System.out.println("El usuario no existe en la aplicación");
        }
    }

    public void optionsMenu() {
        int option;
        do {
            System.out.println("*****************");
            System.out.println("Elige una opción: ");
            System.out.println("*****************");
            System.out.println("1. Post");
            System.out.println("2. Amigos");
            System.out.println("0. Cerrar sesión");
            option = Utils.integer("Seleccione la opción: ");
            switch (option) {
                case 1:
                    System.out.println("Menú Post");
                    this.postMenu();
                    break;
                case 2:
                    System.out.println("Menú Amigos");
                    this.friendsMenu();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Introduce una opción válida");
            }
        } while (option != 0);
        System.out.println("Te has desconectado");
    }

    public void postMenu() {
        int option;
        do {
            System.out.println("********************");
            System.out.println("Elige una opción: ");
            System.out.println("********************");
            System.out.println("1. Añadir un post de texto");
            System.out.println("2. Añadir un post de imagen");
            System.out.println("3. Añadir un post de video");
            System.out.println("4. Ver mis posts");
            System.out.println("5. Eliminar un post");
            System.out.println("6. Comentar un post");
            System.out.println("0. Volver al menú de opciones");
            option = Utils.integer("Seleccione la opción: ");
            switch (option) {
                case 1:
                    System.out.println("Crear post de texto");
                    this.newTextPost();
                    break;
                case 2:
                    System.out.println("Crear post de imagen");
                    this.newImagePost();
                    break;
                case 3:
                    System.out.println("Crear post de video");
                    this.newVideoPost();
                    break;
                case 4:
                    System.out.println("Ver Posts");
                    this.showMyPosts();
                    break;
                case 5:
                    System.out.println("Eliminar post");
                    this.deletePost();
                case 6:
                    System.out.println("Comentar un post");
                case 0:
                    break;
                default:
                    System.out.println("Introduce una opción válida");
            }
        } while (option != 0);
    }

    public void newTextPost() {
        String postTextTitle = Utils.string("Introduce el título de tu post: ");
        String postTextContent = Utils.string("Escribe tu post: ");
        TextPost post = new TextPost(new Date(), postTextTitle, postTextContent);
        // del usuario activo en este momento, dame todos los post y añade y el que acabo de crear.
        this.getActiveUser().getUserPostList().add(post);
        System.out.println("Tu post " + postTextTitle + " se ha creado correctamente");
    }

    public void newImagePost() {
        String postImageTitle = Utils.string("Introduce el título de tu post: ");
        String postImageDimensions = Utils.string("Escribe las dimensiones de tu imagen(Ej: 150 x 150 px): ");
        ImagePost post = new ImagePost(new Date(), postImageTitle, postImageDimensions);
        // del usuario activo en este momento, dame todos los post y añade y el que acabo de crear.
        this.getActiveUser().getUserPostList().add(post);
        System.out.println("Tu post " + postImageTitle + " se ha creado correctamente");
    }

    public void newVideoPost() {
        String postVideoTitle = Utils.string("Introduce el título de tu post: ");
        int postVideoQuality = Utils.integer("¿Cúal es la calidad de tu video?(Ej: 1080): ");
        int postVideoDuration = Utils.integer("¿Cúal es la duración del video (en minutos): ");
        VideoPost post = new VideoPost(new Date(), postVideoTitle, postVideoQuality, postVideoDuration );
        // del usuario activo en este momento, dame todos los post y añade y el que acabo de crear.
        this.getActiveUser().getUserPostList().add(post);
        System.out.println("Tu post " + postVideoTitle + " se ha creado correctamente");
    }
    public void showMyPosts() {
        //this.getActiveUser().getUserPostList().size() > 0
        if (!this.getActiveUser().getUserPostList().isEmpty()) {
            Utils.showFromList(this.getActiveUser().getUserPostList(), false);
        } else {
            System.out.println("No tienes ningún post, comparte algo con tus amigos");
        }
    }
    public void deletePost(){
        this.showMyPosts();
        int postNumber = Utils.integer("¿Qué post quiere borrar? Indica el número: ");
        String message =
                Utils.string("Estás segundo de que quieres borrar el post " + postNumber + "? " +
                        "(Si/No)");
        if (message.equals("Si")){
            this.getActiveUser().getUserPostList().remove(postNumber - 1);
            System.out.println("El post " + postNumber + " ha sido borrado");
        } else if (message.equals("No")){
            this.postMenu();
        } else {
            System.out.println("Por favor introduce una opción correcta, Si o No");
        }
    }

    public void friendsMenu() {
        int option;
        do {
            System.out.println("********************");
            System.out.println("Elige una opción: ");
            System.out.println("********************");
            System.out.println("1. Añadir un amigo");
            System.out.println("2. Ver amigos");
            System.out.println("3. Borrar un amigo");
            System.out.println("4. Ver post de mis amigos");
            System.out.println("0. Volver al menú de opciones");
            option = Utils.integer("Seleccione la opción: ");
            switch (option) {
                case 1:
                    System.out.println("Añadir un amigo");
                    this.addFriend ();
                    break;
                case 2:
                    System.out.println("Ver mis amigos");
                    this.showFriends();
                    break;
                case 3:
                    System.out.println("Eliminar amigos");
                    this.deleteFriends();
                    break;
                case 4:
                    System.out.println("Ver post de mis amigos");
                    this.showFriendsPost();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Introduce una opción válida");
            }
        } while (option != 0);
    }

    public void addFriend (){
        // creo una nueva lista con todos mis amigos
        List <User> friendsAndMyself = new ArrayList<>(this.getActiveUser().getFollowerList());
        // en sea lista me añado a mí mismo
        friendsAndMyself.add(this.getActiveUser());
        // el método Utils.showAndSelectFromList devuelve una lista con todos los elementos de la
        // primera lista que pasas como parámetro menos los elementos de la segunda lista
        List<User> addFriendsList = Utils.showAndSelectFromList(this.getSocialUsers(), true, false,
                friendsAndMyself);
        if(!addFriendsList.isEmpty()){
        this.getActiveUser().getFollowerList().addAll(addFriendsList);
       System.out.println("Has añadido a " + addFriendsList.get(0).getName() + " como " + " amigo");
        }
    }

    public void showFriends() {
        if (!this.getActiveUser().getFollowerList().isEmpty()) {
            Utils.showFromList(this.getActiveUser().getFollowerList(), false);
        } else {
            System.out.println("Se más sociable, haz algún amigo");
        }
    }
    public void deleteFriends(){
        this.showFriends();
        int friendNumber = Utils.integer("¿Qué amigo quieres eliminar? Indica el número: ");
        String message =
                Utils.string("Estás segundo de que quieres eliminar a " +
                        this.getActiveUser().getFollowerList().get(friendNumber - 1) + "? " +
                        "(Si/No)");
        if (message.equals("Si")){
            System.out.println("Tu amigo " + this.getActiveUser().getFollowerList().get(friendNumber - 1) +
                    " ha sido borrado");
            this.getActiveUser().getUserPostList().remove(friendNumber - 1);
        } else if (message.equals("No")){
            this.friendsMenu();
        } else {
            System.out.println("Por favor introduce una opción correcta, Si o No");
        }
    }

    public void showFriendsPost (){
        this.showFriends();
        int friendNumber = Utils.integer("Selecciona el número del amigo del que quieras ver los " +
                "post: ");
        User selectedFriend =
                this.getActiveUser().getFollowerList().get(friendNumber -1);
        List <Post> friendPosts =  new ArrayList<>(selectedFriend.getUserPostList()) ;
        Utils.showFromList(friendPosts, false);
        if(!friendPosts.isEmpty()) {
            String message = Utils.string("¿Quieres comentar algún post? (Si/No) ");
            addComment(message, selectedFriend);
        } else {
            System.out.println(selectedFriend.getName() + " todavía no tiene ningún " +
                    "post ");
        }
    }

    private void addComment(String message, User selectedFriend) {
        if (message.equals("Si")){
            int selectPost = Utils.integer("¿Qué post quieres comentar? (Elige un número) ");
            Post selectedPost = selectedFriend.getUserPostList().get(selectPost -1);
            String comment = Utils.string("Escribe tu comentario: ");
           Comments myComment = new Comments(comment, new Date(), getActiveUser());
            selectedPost.getCommentPostList().add(myComment);
            Utils.showFromList(selectedPost.getCommentPostList(), false);
        } else if (message.equals("No")) {

        } else {
            System.out.println("Introduce un válida");
        }
    }



    // método para crear datos previos en la red social
    private void populateSocialNetwork() {
        User u1 = new User("Marcos");
        User u2 = new User("Paula");
        User u3 = new User("Manuela");
        this.getSocialUsers().add(u1);
        this.getSocialUsers().add(u2);
        this.getSocialUsers().add(u3);
        Post p1 = new ImagePost(new Date(), "Mi fotito", "1080x1080");
        u1.getUserPostList().add(p1);
        u1.getFollowerList().add(u2);
        u2.getFollowerList().add(u1);
        u2.getFollowerList().add(u3);
        u3.getFollowerList().add(u2);
        u3.getFollowerList().add(u1);

    }

// main para ejecutar los métodos:
    //1. creo que el objeto red social (sm)
    //2. ejecuto el método populateSocialNetwork en mi red social
    //3. ejecuto el método mainMenu en mi red social

    public static void main(String[] args) {
        SocialMain sm = new SocialMain();
        sm.populateSocialNetwork();
        sm.mainMenu();

    }

}
