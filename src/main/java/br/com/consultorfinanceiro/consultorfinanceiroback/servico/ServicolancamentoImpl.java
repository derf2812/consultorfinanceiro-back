package br.com.consultorfinanceiro.consultorfinanceiroback.servico;

import java.util.Collection;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import br.com.consultorfinanceiro.consultorfinanceiroback.dao.CategoriaRepository;
import br.com.consultorfinanceiro.consultorfinanceiroback.dao.ContaRepository;
import br.com.consultorfinanceiro.consultorfinanceiroback.dao.LancamentoRepository;
import br.com.consultorfinanceiro.consultorfinanceiroback.dao.TipoLancamentoRepository;
import br.com.consultorfinanceiro.consultorfinanceiroback.modelo.Lancamento;

@Component
public class ServicolancamentoImpl implements ServicoLancamento {
	@Inject
	private TipoLancamentoRepository tpoLancRepo;
	@Inject
	private CategoriaRepository catRepo;
	@Inject
	private LancamentoRepository lancRepo;
	@Inject
	private ContaRepository contaRepo;

	@Override
	public void fazerLancamento(final Lancamento lancamento) {
		tpoLancRepo.findById(lancamento.getTipolancamento().getIdTipoLancamento())
				.ifPresent(lancamento::setTipolancamento);

		catRepo.findById(lancamento.getCategoria().getCategoriaId()).ifPresent(lancamento::setCategoria);

		contaRepo.findById(lancamento.getConta().getContaId()).ifPresent(lancamento::setConta);

		String descLancamento = lancamento.getTipolancamento().getDescricaoLancamento().toLowerCase();

		double valLancamento = lancamento.getValorLancamento();

		if (descLancamento.startsWith("despesa")) {
			double saldoDespesa = lancamento.getConta().getSaldoDespesa() + valLancamento;
			lancamento.getConta().setSaldoDespesa(saldoDespesa);
			valLancamento = -valLancamento;
		} else {
			double saldoReceita = lancamento.getConta().getSaldoReceita() + valLancamento;
			lancamento.getConta().setSaldoReceita(saldoReceita);
		}

		double saldo = lancamento.getConta().getSaldo() + valLancamento;
		lancamento.getConta().setSaldo(saldo);

		lancRepo.save(lancamento);
	}

	@Override
	public Collection<Lancamento> getAllLancamentos() {
		return lancRepo.findAll();
	}

	@Override
	public void apagarLancamento(int idLancamento) {
		lancRepo.deleteById(idLancamento);
	}
}