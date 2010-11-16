/*******************************************************************************
 * Copyright (c) 2010 Torsten Zesch.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser Public License v3
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl.html
 *
 * Contributors:
 *     Torsten Zesch - initial API and implementation
 ******************************************************************************/
package de.tudarmstadt.ukp.wikipedia.api;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;

import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;

import de.tudarmstadt.ukp.wikipedia.api.WikiConstants.Language;

public class TitleIteratorTest {

	private Wikipedia wiki;

	@Before
	public void setupWikipedia() {
		DatabaseConfiguration db = new DatabaseConfiguration();
		db.setDatabase("wikiapi_test");
		db.setHost("bender.tk.informatik.tu-darmstadt.de");
		db.setUser("student");
		db.setPassword("student");
		db.setLanguage(Language._test);
		try {
			wiki = new Wikipedia(db);
		} catch (Exception e) {
			Assume.assumeNoException(e);
			//fail("Wikipedia could not be initialized.");
		}
	}


	@Test
	public void test_titleIteratorTest() {

        int nrOfTitles = 0;
		Iterator<Title> titleIter = wiki.getTitles().iterator();

		while (titleIter.hasNext()) {
			Title t = titleIter.next();
            System.out.println(t.getPlainTitle());
			nrOfTitles++;
		}
		assertEquals("Number of titles == 36", 36, nrOfTitles);

	}
}
