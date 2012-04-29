package testeEntidades;

import static org.junit.Assert.*;

import org.junit.Test;

import entidades.Cliente;

public class ClienteTest {

	@Test
	public void testNomeTabela() {
		Cliente c = new Cliente();
		assertEquals("Cliente", c.nomeTabela());
	}

	@Test
	public void testEqualsObject() {
		Cliente c = new Cliente();
		c.setCpfOrCnpj("12345");
		c.setId_empresa(new Long(1));
		
		Cliente c2 = new Cliente();
		c2.setCpfOrCnpj("12345");
		c2.setId_empresa(new Long(1));
		
		assertEquals(true, c.equals(c2));
	}

	@Test
	public void testGetCamposChave() {
		Cliente c = new Cliente();
		c.setAtivo("S");
		c.setCpfOrCnpj("12345");
		c.setId_empresa(new Long(1));
		
		assertEquals(c, c.getCamposChave());
	}

}
