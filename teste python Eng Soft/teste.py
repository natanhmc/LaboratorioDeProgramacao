from selenium import webdriver
from selenium.webdriver.common.by import By

#Iniciar o navegador
driver = webdriver.Chrome()

#acessar a url do python
driver.get('https:www.python.org/')
#digitar o texto 'python no input'
driver.find_element(By.CSS_SELECTOR,('#id-search-field')).send_keys("python")
#Clicar no botao de pesquisar 
driver.find_element(By.CSS_SELECTOR, ('#submit')).click()
#encerrar o browser
driver.quit()