package Pacotinho;

import java.util.Scanner;

/**
 *
 * @author Filipe Holanda Lins da Silva
 */
public class MenuTest {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        String lista[] = new String[50];
        iniciaVet(lista);
        menu(lista);

    }

    public static void iniciaVet(String[] lista) {
        for (int i = 0; i < lista.length; i++) {
            lista[i] = "";
        }

    }

    public static void menu(String[] lista) {
        byte opcao;

        do {

            System.out.print("Digite :\n [1] Para dicionar um novo nome\n [2] Apresentar os nomes\n [3] Pesquisar um nome\n [4] Remover um nome\n [0] Sair\n");

            opcao = input.nextByte();

            switch (opcao) {

                case 1:

                    adicionarNome(lista);
                    break;

                case 2:
                    mostrarNome(lista);
                    break;
                case 3:
                    consultarNome(lista);

                    break;

                case 4:
                    removerNome(lista);

                    break;

                case 0:

                    break;

                default:
                    System.out.println("Digite um numero valido !");
                    break;

            }
        } while (opcao != 0);

    }

    public static void adicionarNome(String[] lista) {

        int i = 0;
        boolean cond;

        do {

            cond = false;

            if (lista[i] != "") {
                i++;
                cond = true;
            }
            if (i >= lista.length) {
                i = -1;
                cond = false;
            }

        } while (cond != false);

        if (i == -1) {
            System.out.println("Lista cheia");

        } else {
            System.out.print("Digite o nome: ");
            String recebe = input.next();
            boolean existe = false;
            for (int j = 0; j < lista.length; j++) {

                if (recebe.equals(lista[j])) {

                    existe = true;
                }

            }

            if (existe == true) {
                System.out.println("Nome já existe!");

            } else {

                lista[i] = recebe;

            }

        }

    }

    public static void mostrarNome(String[] lista) {

        boolean condicao = true;

        for (int j = 0; j < lista.length; j++) {
            if (lista[j].equals("")) {
                    
            } else {
                condicao = false;
            }

        }
        if (condicao == true) {
            System.out.println(" Não tem nomes na lista para ser visualizado!");

        } else {
            for (int i = 0; i < lista.length; i++) {

                System.out.println((i + 1) + " nome:" + lista[i]);

            }
        }

    }

    public static void consultarNome(String[] lista) {
        System.out.println("Digite o nome a ser pesquisado: ");
        String recebe = input.next();

        boolean encontrado = false;
        int position = 0;

        for (int i = 0; i < lista.length; i++) {
            if (lista[i].equals(recebe)) {

                System.out.println("Nome encontrado: " + lista[i] + " Posição " + (i + 1));
                break;

            }

        }
    }

    public static void removerNome(String[] lista) {

        System.out.print("Digite o nome que você quer remover: ");
        String recebe = input.next();
        int indice = 0;

        for (int i = 0; i < lista.length; i++) {
            if (lista[i].equals(recebe)) {

                lista[i] = "";
                indice = i;
                break;
            }

        }
        for (int i = indice; indice < lista.length; i++) {
            if (i == lista.length - 1) {
                break;
            } else {
                lista[i] = lista[i + 1];
                lista[i + 1] = "";
            }

        }

    }
}
