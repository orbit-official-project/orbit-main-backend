package kr.codemons.orbitproject.domain.utils.proxy;

import kr.codemons.orbitproject.domain.exception.DuplicateHostNameException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Optional;

@Component
public class ProxyManager {
	
	@Value("${proxyServer.scripts.path}")
	private String scriptsPath;
	
	public synchronized void create(Host host) {
		if (isExists(host.getName())) {
			throw new DuplicateHostNameException();
		}
		
		String protocol = host.isSsl() ? "https://" : "http://";
		String address = protocol + host.getIp() + "orbitx.kr";
		
		try {
			String cmd = scriptsPath
				+ "createProxyRoute.ps1 "
				+ host.getName() + " "
				+ address;
			
			Process shellProcess = Runtime.getRuntime().exec("powershell.exe " + cmd);
			shellProcess.waitFor();
		} catch (Exception ignored) {
		}
	}
	
	public void delete(String hostName) {
		String fullPath = scriptsPath + hostName + ".orbitx.kr";
		File conf = new File(fullPath);
		if (conf.exists()) {
			conf.delete();
		}
	}
	
	public Optional<Host> get(String hostName) {
		return Optional.empty();
	}
	
	private boolean isExists(String hostName) {
		return new File(hostName).exists();
	}
}
