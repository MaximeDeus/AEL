import motif.Mot;


import org.junit.*;
import static org.junit.Assert.*;

public class MotTest {
	
	@Test
	public void testIndiceMotifNaif() {
		Mot word = new Mot("helloworld");
		Mot motif1 = new Mot("world");
		Mot motif2 = new Mot("hell");
		Mot motif3 = new Mot("ld");
		Mot motif4 = new Mot("heee");
		Mot motif5 = new Mot("");
		assertEquals(5, word.indiceMotifNaif(motif1));
		assertEquals(0, word.indiceMotifNaif(motif2));
		assertEquals(8, word.indiceMotifNaif(motif3));
		assertEquals(-1, word.indiceMotifNaif(motif4));
		assertEquals(0, word.indiceMotifNaif(motif5));
	}
	
	@Test
	public void testIndiceMotifAutomate() {
		Mot word = new Mot("helloworld");
		Mot motif1 = new Mot("world");
		Mot motif2 = new Mot("hell");
		Mot motif3 = new Mot("ld");
		Mot motif4 = new Mot("heee");
		Mot motif5 = new Mot("");
		assertEquals(5, word.indiceMotifAutomate(motif1));
		assertEquals(0, word.indiceMotifAutomate(motif2));
		assertEquals(8, word.indiceMotifAutomate(motif3));
		assertEquals(-1, word.indiceMotifAutomate(motif4));
		assertEquals(0, word.indiceMotifAutomate(motif5));
	}
	
	@Test
	public void testIndiceMotifKMP() {
		Mot word = new Mot("helloworld");
		Mot motif1 = new Mot("world");
		Mot motif2 = new Mot("hell");
		Mot motif3 = new Mot("ld");
		Mot motif4 = new Mot("heee");
		Mot motif5 = new Mot("");
		assertEquals(5, word.indiceMotifKMP(motif1));
		assertEquals(0, word.indiceMotifKMP(motif2));
		assertEquals(8, word.indiceMotifKMP(motif3));
		assertEquals(-1, word.indiceMotifKMP(motif4));
		assertEquals(0, word.indiceMotifKMP(motif5));
	}
	
	
	

}
