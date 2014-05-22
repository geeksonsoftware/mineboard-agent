package com.geeksonsoftware.mineboard.agent.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;

import com.geeksonsoftware.mineboard.agent.api.CgminerAPI;
import com.geeksonsoftware.mineboard.agent.api.model.CgminerCmdDevs;
import com.geeksonsoftware.mineboard.agent.api.model.CgminerCmdStatus;
import com.geeksonsoftware.mineboard.agent.api.model.CgminerDevice;
import com.geeksonsoftware.mineboard.agent.api.model.CgminerSummary;

public class CgminerApiTest {

	private CgminerAPI cgminerApi;

	@org.junit.Test
	public void testGetDevices() throws IOException {

		initService("/test-requests/cgminer-devs.json");

		CgminerCmdDevs ccd = cgminerApi.getDevices();

		assertNotNull(ccd);

		assertEquals("S", ccd.getSTATUS().get(0).getSTATUS());

		assertEquals(4, ccd.getDEVS().size());
		CgminerDevice device1 = ccd.getDEVS().get(0);
		assertEquals(new Integer(0), device1.getCPU());
		assertEquals(new Double(2.0), device1.getMHS_av());

	}

	@org.junit.Test
	public void testGetStatus() throws IOException {

		initService("/test-requests/cgminer-status.json");

		CgminerCmdStatus ccs = cgminerApi.getStatus();

		assertNotNull(ccs);
		assertEquals("S", ccs.getSTATUS().get(0).getSTATUS());
		CgminerSummary summary = ccs.getSUMMARY().get(0);
		assertNotNull(summary);
		assertEquals(new Integer(39), summary.getGetworks());

	}

	private void initService(String requestFilePath) throws IOException {
		final Socket socket = mock(Socket.class);

		InputStream inputStream = this.getClass().getResourceAsStream(
				requestFilePath);

		assertNotNull(inputStream);

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

		when(socket.getInputStream()).thenReturn(inputStream);
		when(socket.getOutputStream()).thenReturn(outputStream);

		cgminerApi = new CgminerAPI("127.0.0.1", 4028) {
			@Override
			protected Socket createSocket(InetAddress ip, int port) {
				return socket;
			}
		};
	}
}
