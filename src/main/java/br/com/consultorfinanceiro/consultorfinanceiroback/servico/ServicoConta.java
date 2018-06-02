package br.com.consultorfinanceiro.consultorfinanceiroback.servico;

import java.util.Optional;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import br.com.consultorfinanceiro.consultorfinanceiroback.dao.ContaRepository;
import br.com.consultorfinanceiro.consultorfinanceiroback.modelo.Conta;
import br.com.consultorfinanceiro.consultorfinanceiroback.utils.Encrypt;

@Component
public class ServicoConta 
{
	@Inject
	private ContaRepository repositorio;
	
	public void zerarSaldo( 
		final int contaId )
	{
		repositorio.findById( contaId ).ifPresent( c -> {
			c.setSaldo(0d);
			c.setSaldoDespesa(0d);
			c.setSaldoReceita(0d);
			repositorio.save(c);
		});
	}
	
	public Optional<Conta> criarNovaConta(
		final Conta contaFake )
	{
		contaFake.setSaldo(0d);
		contaFake.setSaldoDespesa(0d);
		contaFake.setSaldoReceita(0d);
		contaFake.setLimiteGastoMensal(70d);
		
		contaFake.setSenha( Encrypt.toHash( contaFake.getSenha( ) ) );
		
		return Optional.of(repositorio.save(contaFake));
	}
}