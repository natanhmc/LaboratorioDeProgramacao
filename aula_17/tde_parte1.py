from selenium import webdriver
from selenium.webdriver.common.by import By

#Iniciar o navegador
driver = webdriver.Chrome()

driver.get('https://www.google.com.br/')

search_box = driver.find_element("name", "q")
search_box.send_keys('Computação ULBRA Torres')
search_box.submit()
#Clicar no botao de pesquisar 
driver.find_element(By.CSS_SELECTOR, ('#submit')).click()
#encerrar o browser
driver.quit()