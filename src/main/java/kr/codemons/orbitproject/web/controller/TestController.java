package kr.codemons.orbitproject.web.controller;

import kr.codemons.orbitproject.domain.utils.proxy.Host;
import kr.codemons.orbitproject.domain.utils.proxy.ProxyManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/proxy")
@RequiredArgsConstructor
public class TestController {

    private final ProxyManager proxyManager;

    @GetMapping
    public void test() {
        Host host = new Host("127.0.0.1", 4522, false, "joyoungjun", true);
        proxyManager.create(host);

        log.info("done");
    }

    @GetMapping("/delete")
    public void delete() {
        proxyManager.delete("joyoungjun");
    }
}
