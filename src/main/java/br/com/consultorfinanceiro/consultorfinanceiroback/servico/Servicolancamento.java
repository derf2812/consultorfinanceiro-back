package br.com.consultorfinanceiro.consultorfinanceiroback.servico;

import java.util.Collection;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import br.com.consultorfinanceiro.consultorfinanceiroback.dao.CategoriaRepository;
import br.com.consultorfinanceiro.consultorfinanceiroback.dao.ContaRepository;
import br.com.consultorfinanceiro.consultorfinanceiroback.dao.LancamentoRepository;
import br.com.consultorfinanceiro.consultorfinanceiroback.dao.TipoLancamentoRepository;
import br.com.consultorfinanceiro.consultorfinanceiroback.modelo.Conta;
import br.com.consultorfinanceiro.consultorfinanceiroback.modelo.Lancamento;
import br.com.consultorfinanceiro.consultorfinanceiroback.servicos.dtp.ValidacaoPercentualDTO;

@Component
public class Servicolancamento
{
	@Inject
	private TipoLancamentoRepository tpoLancRepo;
	@Inject
	private CategoriaRepository catRepo;
	@Inject
	private LancamentoRepository lancRepo;
	@Inject
	private ContaRepository contaRepo;

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

	public Collection<Lancamento> getAllLancamentos() {
		return lancRepo.findAll();
	}

	public void apagarLancamento(int idLancamento) 
	{
		lancRepo.findById(idLancamento).ifPresent(lanc->{
			String descLancamento = lanc.getTipolancamento().getDescricaoLancamento().toLowerCase();
			double valLancamento = lanc.getValorLancamento();
			
			if (descLancamento.startsWith("receita")) {
				double saldoReceita = lanc.getConta().getSaldoReceita() - valLancamento;
				lanc.getConta().setSaldoReceita(saldoReceita);
				valLancamento = -valLancamento;
			} else {
				double saldoDespesa = lanc.getConta().getSaldoDespesa() - valLancamento;
				lanc.getConta().setSaldoDespesa(saldoDespesa);
				valLancamento = +valLancamento;
			}

			double saldo = lanc.getConta().getSaldo() + valLancamento;
			lanc.getConta().setSaldo(saldo);
			
			contaRepo.save(lanc.getConta());
			lancRepo.deleteById(idLancamento);
		});
	}

	public Collection<Lancamento> findAllByContaId(Integer contaId) {
		return lancRepo.findAllByContaId(contaId);
	}

	public ValidacaoPercentualDTO validarLancamento(
		final Lancamento lancamento )
	{
		tpoLancRepo.findById(lancamento.getTipolancamento().getIdTipoLancamento()).ifPresent(lancamento::setTipolancamento);
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
		Conta conta = lancamento.getConta();
		conta.setSaldo(saldo);
		
		ValidacaoPercentualDTO validacaoPercentualDTO = new ValidacaoPercentualDTO();
		validacaoPercentualDTO.setPassou(
			Math.round( ( ( conta.getSaldoDespesa() * 100 ) / conta.getSaldoReceita() ) ) > conta.getLimiteGastoMensal( ) );
		return validacaoPercentualDTO;
	}
}