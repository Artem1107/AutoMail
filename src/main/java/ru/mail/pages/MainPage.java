package ru.mail.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import ru.mail.steps.Base;

import java.util.List;

public class MainPage extends Base {

    public MainPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = ".//span[@class='ph-project__user-name svelte-1hiqrvn']")
    private WebElement userNameMenu;

    @FindBy(xpath = "//span[@class='compose-button__txt']")
    private WebElement writeLetterBtn;

    @FindBy(xpath = "//a[@class = 'nav__item js-shortcut nav__item_active nav__item_shortcut nav__item_child-level_0']")
    private WebElement inboxBtn;

    @FindBy(xpath = "//a[@class='llc llc_has-indent llc_new llc_new-selection js-letter-list-item js-tooltip-direction_letter-bottom'][1]//span[@class='ll-sj__normal']")
    private WebElement summaryLetter;

    @FindBy(xpath = "//h2[@class='thread-subject']")
    private WebElement summaryInLetter;

    @FindBy(xpath = "//div[text()='Hello']")
    private WebElement textInLetter;

    /**
     * Кнопка Настройки для маленького экрана
     */
    @FindBy(xpath = ".//span[@data-highlighted-class='button2_highlighted' and @title = 'Настройки']")
    private WebElement settingsBtn;

    /**
     * Кнопка Настройки для большого экрана
     */
    @FindBy(xpath = ".//div[@class='button2__txt' and text()='Настройки']")
    private WebElement settingsBtn2;

    @FindBy(xpath = "//div[@class='ph-project-promo-close-icon__container svelte-m7oyyo']")
    private WebElement closeBanner;

    @FindBy(xpath = "//div[@class='mt-h-c__content']")
    private WebElement receivedLetter;

    @FindBy(xpath = "//span[@class='mt-t mt-t_tomyself mt-t_unread mt-t_no-caps']")
    private WebElement letterYourself;

    @FindBy(xpath = "//a[@class='llc llc_has-indent llc_new llc_new-selection js-letter-list-item js-tooltip-direction_letter-bottom'][1]//span[@class='llc__subject llc__subject_unread']")
    private WebElement lastReceivedLetter;

    @FindBy(xpath = "//div[@class='llc__avatar']")
    private WebElement iconAboutLetter;

    @FindBy(xpath = "//div[@class='checkbox__box checkbox__box_checked']")
    private WebElement checkboxAboutLettter;

    @FindBy(xpath = "//span[@class='button2 button2_has-ico button2_has-ico-s button2_delete button2_pure button2_ico-text-top button2_hover-support js-shortcut']")
    private WebElement deleteLeterBtn;

    @FindBy(xpath = "//span[text()='Писем нет']")
    private WebElement letterNo;

    @FindBy(xpath = "//div[@class = 'wrapperBg-0-2-21']")
    private WebElement file;

    @FindBy(xpath = "//small[@class = 'base-0-2-30 small-0-2-39 auto-0-2-55' and text()='autoTest.doc']")
    private WebElement fileName;

    @FindBy(xpath = "//a[@data-name= 'download-link']")
    private WebElement downloadFile;


    /**
     * Получаем все чекбоксы письма и кликаем на них
     */
    public void clickAllCheckboxAboutLetter() throws InterruptedException {
        Actions actions = new Actions(getDriver());

        List<WebElement> icons = getDriver().findElements(By.xpath("//span[@class='ll-av__img']"));
        for (WebElement icon : icons) {
            actions.moveToElement(icon).click().perform();
        }
    }

    /**
     * Получаем надпись писем нет
     */
    public String getTextLetterNo() {
        return letterNo.getText();
    }

    /**
     * метод нажатия на удалить сообщения
     */
    public void clickDeleteLeterBtn() {
        click(deleteLeterBtn);
    }


    /**
     * метод для получения текста темы письма из общего списка
     */
    public String getSummaryLetter() {
        return getText(summaryLetter);
    }


    /**
     * метод для получения текста темы письма из открытого письма
     */
    public String getTextInLetter() {
        return getText(textInLetter);
    }

    /**
     * метод для получения текста письма
     */
    public String getSummaryInLetter() {
        return getText(summaryInLetter);
    }

    /**
     * метод текста из меню авторизованого пользователя
     */
    public String getTextUserNameMenu() {
        return getText(userNameMenu);
    }

    /**
     * метод закрытия банера
     */
    public void clickCloseBanner() {
        if (waitVisibalElement(closeBanner, 5)) {
            click(closeBanner);
        }
    }

    /**
     * метод нажатия на написать письмо
     */
    public void clickWriteLetterBtn() {
        click(writeLetterBtn);
    }

    /**
     * метод нажатия на Входящие
     */
    public void clickInboxBtn() {
        click(inboxBtn);
    }

    /**
     * метод нажатия на 'письма себе'
     */
    public void clickLetterYourself() {
        click(letterYourself);
    }

    /**
     * метод нажатия на тему письма для его открытия
     */
    public void clickSummaryLetter() {
        click(summaryLetter);
    }

    /**
     * метод перехода в настройки
     */
    public void clickSettingsBtn() {
        click(settingsBtn);
    }

    /**
     * метод перехода в настройки2
     */
    public void clickSettingsBtn2() {
        click(settingsBtn2);
    }

    /**
     * метод скачать файл
     */
    public void downloadFile() {
        click(downloadFile);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Получаем название файла
     */
    public String getFileName() {
        return fileName.getText();
    }

}


