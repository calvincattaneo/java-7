package challenge;

import java.util.ArrayList;
import java.util.List;

public class Estacionamento {

	int limiteVagas = 10;
	List<Carro> vagas = new ArrayList<>();

    public void estacionar(Carro carro) {
        if (vagas.size() == 10) {
            removeMotorista(0);
        }
        vagas.add(carro);
    }

    public int carrosEstacionados() {
        return vagas.size();
    }

    public boolean carroEstacionado(Carro carro) {
        return vagas.contains(carro);
    }

    private void removeMotorista(int posicao) {
        Carro carroSelecionado = vagas.get(posicao);
        if (carroSelecionado.getMotorista().getIdade() > 55) {
            posicao++;
            if (posicao < vagas.size()) {
                removeMotorista(posicao);
            } else {
                throw new EstacionamentoException("Vaga indisponível, os motoristas tem 55 anos ou mais");
            }
        } else {
            vagas.remove(posicao);
        }
    }
}
