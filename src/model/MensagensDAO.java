package model;

public class MensagensDAO {    
    
    Mensagens[] mensagens = new Mensagens[100];

    public MensagensDAO() {  
        Mensagens m1 = new Mensagens();
        m1.setNomeDoMensageiro("Fulano");
        m1.setMensagem("Olá! Que a união de vocês seja repleta de amor, respeito e felicidade! Felicidades!");
        m1.setDataCriacao();      
        mensagens[0] = m1;

        Mensagens m2 = new Mensagens();
        m2.setNomeDoMensageiro("Fulano");
        m2.setMensagem("Meu casal.");
        m2.setDataCriacao();      
        mensagens[1] = m2;
    }

    public boolean criaMensagem(String nomeEnviado, String mensagemEnviada) {
        for (int i = 0; i < mensagens.length; ++i){
            if (mensagens[i] == null) {
                mensagens[i] = new Mensagens();
                mensagens[i].setNomeDoMensageiro(nomeEnviado);
                mensagens[i].setMensagem(mensagemEnviada);
                mensagens[i].setDataCriacao();
                return true;
            }
        }
        return false;
    }

    public boolean atualizaMensagem(String nomeDoMensageiro, String mensagem, int id) {
        int i = 0;
        while (mensagens[i] != null && mensagens[i].getId() != id || mensagens[i] == null) {
            i++;
        }

        if (mensagens[i] != null && mensagens[i].getId() == id) {
            if (!nomeDoMensageiro.equals("")) {
                mensagens[i].setNomeDoMensageiro(nomeDoMensageiro);
            }
            if (!mensagem.equals("")) {
                mensagens[i].setMensagem(mensagem);
            }
            mensagens[i].setDataModificacao();
            return true;
        }
        return false;
    }

    public void excluiMensagem(int id) {
        int i = 0;
        while (mensagens[i] != null && mensagens[i].getId() != id || mensagens[i] == null) {
            i++;
        }

        if (mensagens[i] != null && mensagens[i].getId() == id) {
            mensagens[i] = null;
        }
    }

    public String verMensagens() {
        String m = "";
        for (int i = 0; i < mensagens.length; i++) {
            if (mensagens[i] != null) {
                m += mensagens[i] + "\n";
            }
        }
        return m;
    }

    public Mensagens verMensagem(int id) {
        return mensagens[id - 1];
    }
}
