package com.QA.TestApp.Pages.WEB;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

import com.QA.TestApp.Utilities.BaseScript;


public class TDL_CRM_DetailsPage extends BaseScript {

   //login
	@FindBy(xpath = "//*[contains(text(),'Login to the support portal')]")
	public WebElement support_portal;

	@FindBy(xpath = "//*[contains(text(),'Are you an agent? ')]//following-sibling::a")
	public WebElement Login;

	@FindBy(xpath = "//label[text()='Email']//following-sibling::div/div/div/input")
	public WebElement Username;

	@FindBy(xpath = "//label[text()='Password']//following-sibling::div/div/div/input")
	public WebElement password;

	@FindBy(xpath = "//button[text()='Sign in']")
	public WebElement signin;

	@FindBy(xpath = "//*[@*='trigger-power-select']//span")
	public WebElement Div_Contact;

	@FindBy(xpath = "//*[@*='trigger-power-select']//input")
	public WebElement Contact_Input_field_in_new_ticket_Page;

	@FindBy(xpath = "//*[text()='Subject']/following::input[1]")
	public WebElement Subject_Input_field_in_new_ticket_Page;

	@FindBy(xpath = "(//*[text()='Category']/following::*[@*='trigger-power-select'])[1]")
	public WebElement category_dropdown;

	@FindBy(xpath = "(//*[text()='Brand']/following::*[@*='trigger-power-select'])[1]")
	public WebElement Brand_dropdown;

	@FindBy(xpath = "(//*[text()='Type']/following::*[@*='trigger-power-select'])[1]")
	public WebElement Type_Dropdown;

	@FindBy(xpath = "(//*[text()='Issue Category']/following::*[@*='trigger-power-select'])[1]")
	public WebElement Issue_Category_dropdown;

	@FindBy(xpath = "(//*[text()='Issue Classification']/following::*[@*='trigger-power-select'])[1]")
	public WebElement Issue_Classification_Dropdown;

	@FindBy(xpath = "(//*[text()='Group']/following::*[@*='trigger-power-select'])[1]")
	public WebElement Description_Textbox;

	@FindBy(xpath = "//*[@data-test-id='froala-editor-component']")
	public WebElement Group_Dropdown;

	@FindBy(xpath = "//*[text()='SN Ticket ID']/following::input[1]")
	public WebElement SN_Ticket_ID;

	@FindBy(xpath = "//*[text()='Name']/following::input[1]")
	public WebElement name_input_field;

	@FindBy(xpath = "//*[text()='Phone number']/following::input[1]")
	public WebElement Phone_number_input_Field;

	@FindBy(xpath = "//*[text()='Tags']/following::input[1]")
	public WebElement Tags_input_Field;

	@FindBy(xpath = "//*[text()='Create']")
	public WebElement Create_btn;

	// New Email Page-7th Sep 2020
	@FindBy(xpath = "//*[contains(@id,'ember-power-select-search-input-ember')]")
	public WebElement To_Input_Field_In_New_Email_Page;

	@FindBy(xpath = "//*[contains(@id,'subject_ember')]")
	public WebElement Subject_Input_Field_in_New_Email_Page;

	@FindBy(xpath = "//*[@data-test-id='froala-editor-component']")
	public WebElement Description_Text_Area_in_New_Email_Page;

	@FindBy(xpath = "(//*[text()='Priority']/following::div)[1]")
	public WebElement Priority_Input_Field_In_New_Email_page;

	@FindBy(xpath = "(//*[text()='Status']/following::div)[1]")
	public WebElement Status_Input_field_In_New_Email_Page;

	@FindBy(xpath = "//*[contains(@id,'ember-power-select-trigger-multiple-input-ember')]")
	public WebElement Tags_input_Field_In_New_Eamil_page;

	@FindBy(xpath = "//*[normalize-space(text())='Send']")
	public WebElement Send_Button_In_New_Email_page;

	// New contact page
	@FindBy(xpath = "//*[contains(@id,'name_ember')]")
	public WebElement First_Name_input_field_in_New_Contact_page;

	@FindBy(xpath = "//*[contains(@id,'jobTitle_ember')]")
	public WebElement Title_input_field_in_New_Contact_page;

	@FindBy(xpath = "//*[@data-test-id='email-test-id']")
	public WebElement Email_address_input_field_in_New_Contact_Page;

	@FindBy(xpath = "//*[contains(@id,'phone_ember')]")
	public WebElement Work_phone_in_New_Contact_Page;

	@FindBy(xpath = "//*[contains(@id,'twitterId_ember')]")
	public WebElement Twitter_in_New_Contact_Page;

	@FindBy(xpath = "//*[contains(@id,'uniqueExternalId_ember')]")
	public WebElement UniqueexternalEmailId_In_New_contact_Page;

	@FindBy(xpath = "//*[contains(@id,'customFields.customer_hash_ember')]")
	public WebElement Customer_Hash_in_new_contact_Page;

	@FindBy(xpath = "//*[contains(@id,'ember-power-select-search-input-ember')]")
	public WebElement Company_Input_Field_In_New_contact_Page;

	@FindBy(xpath = "//*[contains(@id,'address_ember')]")
	public WebElement Address_Text_Area_in_New_Contact_page;

	@FindBy(xpath = "(//*[text()='Time zone']/following::div)[1]")
	public WebElement Time_Zone_in_New_Contact_page;

	@FindBy(xpath = "(//*[text()='Language']/following::div)[1]")
	public WebElement Language_in_New_Contact_page;

	@FindBy(xpath = "//*[text()='Tags']/following::*[contains(@id,'ember-power-select-trigger-multiple-input-ember')]")
	public WebElement Tags_in_New_Contact_page;

	@FindBy(xpath = "//*[contains(@id,'description_ember')]")
	public WebElement Description_in_New_Contact_page;

	// New Company
	@FindBy(xpath = "//*[contains(@id,'name_ember')]")
	public WebElement Company_Name_input_field_in_New_Company_page;

	@FindBy(xpath = "//*[contains(@id,'description_ember')]")
	public WebElement Description_input_field_in_New_Company_page;

	@FindBy(xpath = "//*[contains(@id,'note_ember')]")
	public WebElement note_input_field_in_New_Company_page;

	@FindBy(xpath = "//*[text()='Domains for this company']/following::*[contains(@id,'ember-power-select-trigger-multiple-input-ember')]")
	public WebElement Domain_For_this_Company_input_field_in_New_Company_page;

	@FindBy(xpath = "(//*[text()='Health score']/following::div)[1]")
	public WebElement Health_Score_input_field_in_New_Company_page;

	@FindBy(xpath = "(//*[text()='Account tier']/following::div)[1]")
	public WebElement Account_Tier_input_field_in_New_Company_page;

	@FindBy(xpath = "(//*[text()='Renewal date']/following::div)[1]")
	public WebElement Renewal_Date_input_field_in_New_Company_page;

	@FindBy(xpath = "(//*[text()='Industry']/following::div)[1]")
	public WebElement Industry_input_field_in_New_Company_page;

	@FindBy(xpath = "//*[@data-testid='homenavbar']//*[contains(@class,'Avatar')]")
	public WebElement AvtarInSitHomepage;

	@FindBy(xpath = "//*[text()='Help']")
	public WebElement Helpbutton;

	@FindBy(xpath = "//*[@title='Faq']")
	public WebElement FaqInHelpPage;

	@FindBy(xpath = "//*[text()='Write to Us']")
	public WebElement WriteToUs;

	@FindBy(xpath = "//*[text()='Call Us']")
	public WebElement CallUs;

	@FindBy(xpath = "//*[text()='Email Us']")
	public WebElement EmailUs;

	@FindBy(xpath = "//*[contains(@id,'s2id_helpdesk_ticket_custom_field_cf_reason')]")
	public WebElement Reason_In_WriteToUs;

	@FindBy(xpath = "//*[contains(@id,'select2-result-label-4')]")
	public WebElement ResonDropDownInWriteToUs;

	@FindBy(xpath = "//*[@id='helpdesk_ticket_ticket_body_attributes_description_html']")
	public WebElement DescriptionIn_WriteToUs;

	@FindBy(xpath = "//*[text()='Submit']")
	public WebElement SubmitButton;

	@FindBy(xpath = "//*[text()='Yes']")
	public WebElement YesButton;

	@FindBy(xpath = "//*[text()='Back to Homepage']")
	public WebElement BackToHomepage;

	@FindBy(xpath = "//*[contains(@class,'modal-body')]")
	public WebElement CallToUsPopUp;

	@FindBy(xpath = "(//*[contains(@class,'modal-body')])[2]")
	public WebElement EmailUsPopUp;

	@FindBy(xpath = "//*[@id='profileDropdown']")
	public WebElement Avtar_In_CRM_page;

	@FindBy(xpath = "//*[text()='Profile settings']")
	public WebElement Profile_settings_in_profileDropDown;

	@FindBy(xpath = "//*[text()='Profile Details']/following::ul")
	public WebElement ProfileDetails;

	@FindBy(xpath = "//*[text()='View all']")
	public WebElement ViewAll;

	@FindBy(xpath = "//*[contains(text(),'Tata loyalty')]")
	public WebElement TataLoyalityText;

	@FindBy(xpath = "//*[text()='Click here']")
	public WebElement Click_Here_Text;

	@FindBy(xpath = "//*[@title='Ticket']")
	public WebElement Ticket_Button;

	@FindBy(xpath = "//*[normalize-space(text())='Open']")
	public WebElement Open_Text_In_Ticket_Page;

	// TIC And TDC
	@FindBy(xpath = "//*[@id='omnibar-trigger-button']")
	public WebElement click_on_freshworks_switchers;

	@FindBy(xpath = "//*[@title='Tatdigitalsit']")
	public WebElement click_on_freshchat;

	@FindBy(xpath = "//*[text()='Resolved']")
	public WebElement click_on_dropdown_resolved;

	@FindBy(xpath = "//*[@id='ember234']")
	public WebElement click_on_the_first_chat_in_freschat_resolved;

	@FindBy(xpath = "//*[@id='ember-power-select-option-1']")
	public WebElement click_on_tcp_non_voice_in_assign_to;

	@FindBy(xpath = "//*[@id='ember-power-select-option-2']")
	public WebElement tic_in_assign_to;

	@FindBy(xpath = "//*[contains(text(),'Conversation was assigned to group TCP Non Voice')]")
	public WebElement validate_tcp_non_voice;

	@FindBy(xpath = "//*[contains(text(),'Conversation was assigned to group TIC Non Voice')]")
	public WebElement validate_tic_non_voice;

	@FindBy(xpath = "//*[@id='ember1394']")
	public WebElement Add_Label;

	@FindBy(xpath = "//*[@id='ember-power-select-option-0']")
	public WebElement LabelDropdown;

	@FindBy(xpath = "(//*[@class='label-assigned'])[2]")
	public WebElement Labelassigned;

	@FindBy(xpath = "//*[@class='inbox-empty-wrapper']")
	public WebElement FreshChatValidation;

	@FindBy(xpath = "//*[text()='New']")
	public WebElement New_DropDown;

	@FindBy(xpath = "//*[text()='Assign to']/following-sibling::span")
	public WebElement Assign_To_Dropdown;

	@FindBy(xpath = "//*[(text()='Order History')]")
	public WebElement Order_History;

	@FindBy(xpath = "//*[text()='My Orders']")
	public WebElement Order_History_Page;

	@FindBy(xpath = "//*[@id='ember167']//*[text()='Yes']")
	public WebElement Yes_Button;

	@FindBy(xpath = "//*[@id='crsDropDown']//a")
	public WebElement Canned_Response_button;

	@FindBy(xpath = "//*[text()='General']")
	public WebElement General_Button;

	@FindBy(xpath = "(//*[text()='assistance'])[2]/following::*[text()='Add']")
	public WebElement Add_Button;

	@FindBy(xpath = "//*[contains(@class,'editable')]//p")
	public WebElement Validation_Of_Comment_Box;

	@FindBy(xpath = "//*[text()='Assigned To Me']")
	public WebElement ClickOn_Assigned_To_Me_Option;

	@FindBy(xpath = "//*[contains(@class,'view-filter')]")
	public WebElement Assigned_To_Me_Option_validation;

	@FindBy(xpath = "//*[text()='Set active on Omniroute']")
	public WebElement Active_Button_InAvtar;

	@FindBy(xpath = "//*[contains(text(),'You are now')]")
	public WebElement Succes_message_After_Clicking_On_Active_Button;

	@FindBy(xpath = "//*[contains(@*,'login-session')]")
	public WebElement Profile_Avtar_in_Freshchat_Page;

	@FindBy(xpath = "//*[@id='send-and-set']")
	public WebElement Create_button;

	@FindBy(xpath = "//*[text()='Ticket created']")
	public WebElement Validation_For_Create_Ticket;

	@FindBy(xpath = "//*[@data-test-id='dialog-confirm-button']")
	public WebElement Delete_Button;
	
	@FindBy(xpath = "//*[text()='Delete']")
	public WebElement Click_Delete_Button;
	
	@FindBy(xpath = "//*[@data-test-id='dialog-confirm-button']")
	public WebElement Delete_Button_In_Dilog_Alert_Box;

	@FindBy(xpath = "//*[text()='Ticket deleted']")
	public WebElement Validation_For_Delete_Ticket;

	@FindBy(xpath = "//*[@aria-label='New']")
	public WebElement New_button;

	@FindBy(xpath = "//*[text()='New ticket']")
	public WebElement New_Ticket_button;

	@FindBy(xpath = "//*[normalize-space(translate(text(),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'))='add new contact']")
	public WebElement btnAddNewContact;

	@FindBy(xpath = "//*[text()='Add Cc']")
	public WebElement btnAddCc;

	@FindBy(xpath = "//li[@role='option'][not (contains(text(), 'Add'))]")
	public WebElement option;
    //Sailendra
	@FindBy(xpath = "//*[@class='search-toggle ml-16']")
	public WebElement Search_click;
	
	@FindBy(xpath = "//*[@data-test-id='quick-search-input']")
	public WebElement Search_Text_Enter;
	
	@FindBy(xpath = "//span[@data-test-ticket-id='2128']//ancestor::a[1]")
	public WebElement Search_Result_Click;
	
	@FindBy(xpath = "//span[@data-test-ticket-id='2123']//ancestor::a[1]")
	public WebElement Search_Result_Clicks;
	
	@FindBy(xpath = "//*[contains(text(),'Change name from Sankit to Saket')]")
	public WebElement Text_Verification;
	
	@FindBy(xpath = "//*[contains(text(),'Action performed')]")
	public WebElement Text_Verifiys;
	
	@FindBy(xpath = "//span[@data-test-ticket-id='422']//ancestor::a")
	public WebElement Text_Click;
	
	@FindBy(xpath = "//*[text()='All tickets']/following::div[text()='422']")
	public WebElement Text_Verify;
	
	@FindBy(xpath = "//span[@data-test-ticket-id='319']//ancestor::a")
	public WebElement Ticket_Clicks;
	
	@FindBy(xpath = "//*[text()='All tickets']/following::div[text()='319']")
	public WebElement Text_Verify1;
	
	@FindBy(xpath = "//a[@data-test-id='nav-dashboard']")
	public WebElement dashboard_click;

	@FindBy(xpath = "//*[text()='Open']//ancestor::a[1]")
	public WebElement Staus_click;

	@FindBy(xpath = "//a[text()='Open tickets']")
	public WebElement Verify_staus;

	@FindBy(xpath = "//span[@data-test-ticket-id='2184']//ancestor::a[1]")
	public WebElement Search_Result_Click_2184;
	
	@FindBy(xpath = "//a[contains(text(),'Reversal Redemption approval')]")
	public WebElement Search_Result_Click_2243;
	
	
	@FindBy(xpath = "//*[@class='search-toggle ml-16']")
	public WebElement Search_click_redeem_points;
			
	@FindBy(xpath = "//*[@data-test-id='quick-search-input']")
	public WebElement Search_Text_Enter_redeem_points;

	@FindBy(xpath = "//span[@data-test-ticket-id='2124']//ancestor::a[1]")
	public WebElement Search_Result_Click_redeem_points;

	@FindBy(xpath = "//*[text()='Redeem points']")
	public WebElement redeem_points_link;

	@FindBy(xpath = "//*[@data-test-id='breadcrumb-item']")
	public WebElement validate_redeem_points;

	@FindBy(xpath = "//*[@class='search-toggle ml-16']")
	public WebElement Search_click_Membership_Tier;

	@FindBy(xpath = "//a[text()='Membership Tier']")
	public WebElement Membership_Tier_2102;

	@FindBy(xpath = "//*[@data-test-id='quick-search-input']")
	public WebElement Search_Text_Enter_Membership_Tier;

	@FindBy(xpath = "(//*[text()='Membership Tier'])[1]")
	public WebElement Validate_Membership_tier;
	
	@FindBy(xpath = "//button[@id='techOps_button']")
	public WebElement btn_RaiseITSMTicket;
	
	@FindBy(xpath = "//iframe[@id='1mroega5']")
	public WebElement frameRaiseITSMTicket;
	
	@FindBy(xpath = "//img[@alt='Raise Ticket to ITSM']")
	public WebElement optionRaiseITSMTicket;
	
	@FindBy(xpath = "//*[@id='successMessage']")
	public WebElement msg_SuccessITSMTicketCreated;
	
	//Deepika-02/11/2020
	@FindBy(xpath = "//a[@data-test-link='tickets-subject-669']")
	public WebElement click_on_ticket_669;
	
	@FindBy(xpath = "//span[text()='CRM_OFFER_INFO_ENQUIRY_CS_157']")
	public WebElement validate_ticket_669;
	//Deepika
	//Sailendra
    @FindBy(xpath = "//a[text()='GOODWILL_POINTS_TO_CUSTOMER_ON_SLA_BREACH']")
	public WebElement SLA_Breach;
	
	@FindBy(xpath = "//*[text()='Good will points added due to SLA breach']")
	public WebElement Action_performed;
	//sailendra
	
	@FindBy(xpath = "//*[text()='Solutions']")
	public WebElement validate_FAQ_Query;
	
	//Deepu-3/11/2020
	@FindBy(xpath = "//*[@data-test-id='timeline-icon-phone']")
	public WebElement click_on_phone_icon;
	
	@FindBy(xpath = "//*[text()='Emails']/following::div")
	public WebElement email_verification;
	
	@FindBy(xpath = "//*[text()='View more info']")
    public WebElement click_on_view_more_info;
	
	@FindBy(xpath = "//*[@class='Avatar__StyleAvatar-jgKLjF koXgoN']")
    public WebElement click_on_initials;
    
    @FindBy(xpath = "//*[text()='Help']")
    public WebElement click_help_button;
    
    @FindBy(xpath = "//*[text()='FAQ']")
    public WebElement validate_Help_Page;
    
    @FindBy(xpath = "//*[@rel='page-search']")
    public WebElement Search_Bar_Help_page;
    //Deepika
    @FindBy(xpath="//*[@data-test-id='ticket-status']")
    public WebElement msgTicketStatus;
    
    @FindBy(xpath="//*[text()='Update']")
    public WebElement btnUpdate;
    
    @FindBy(xpath="//*[text()='Properties updated']")
    public WebElement msgUpdate;
    
    @FindBy(xpath = "//*[text()='Email']//following::div")
	public WebElement email_element_ticket_page;
    
    @FindBy(xpath = "//*[@data-test-id='ticket-checkbox']//ancestor::div[3]")
	public WebElement random_ticket_click;
    
    @FindBy(xpath = "//*[@data-test-id='timeline-icon-email']")
   	public WebElement click_on_email_icon;
       
    @FindBy(xpath = "//*[@data-test-id='timeline-icon-chat']")
   	public WebElement click_on_chat_icon;
    
    @FindBy(xpath = "//*[@id='search-btn']")
   	public WebElement Advanced_Search;
  
    @FindBy(xpath = "//*[@id='programID']")
   	public WebElement Dropdown_ProgramID;
    
    @FindAll(@FindBy(xpath = "//*[contains(@*,'grprofile')]"))
   	public List<WebElement> secGRProfile;
    
    @FindBy(xpath="(//*[contains(@*,'ticket-details-header')]/following::*[@data-test-id='user-name'])[1]")
    public WebElement lnkUser_TicketArea;
    
    @FindBy(xpath = "//*[@*='user-content']")
   	public WebElement popupUserDetails;
    
    @FindBy(xpath = "//*[@*='user-content']//*[@*='Unverified contacts']")
   	public WebElement iconUnverified;
  
    @FindBy(xpath = "//*[@aria-label='Suggested solutions']")
   	public WebElement iconleftpanel_Solutions;
  
    @FindBy(xpath = "//input[@data-test-id='solution-search']")
   	public WebElement txtBoxSearch_Solutions;
    
    @FindBy(xpath = "//*[@aria-label='Insert article']")
   	public WebElement insert_article_button;
    
    @FindBy(xpath = "//*[@data-test-id='froala-editor-component']//p")
   	public WebElement paragraph_element;
    
    @FindBy(xpath = "//div[text()='Date Updated']")
   	public WebElement customer_details;
  
    @FindBy(xpath = "//div[@data-test-id='articles-search-no-result']")
   	public WebElement areaNoSearchFound_Solutions;
  
    @FindBy(xpath = "//*[text()='Solution articles']")
   	public WebElement pageName_KnowledgeBase;
    
    @FindBy(xpath = "//div[@class='orders order-transaction']")
   	public WebElement loyalty;
    
    @FindBy(xpath = "//button[@*='Forward ( f )']")
   	public WebElement btn_Forward;
    
    @FindBy(xpath = "//*[text()='To']//following::input")
   	public WebElement field_to;
    
    @FindBy(xpath = "//*[text()='From']//following::span")
   	public WebElement field_from_text;
    
    @FindBy(xpath = "//button[@*='Reply ( r )']")
   	public WebElement btn_Reply;
    
    @FindBy(xpath = "//button[@*='Add note ( n )']")
   	public WebElement btn_AddNote;
    
  
    @FindBy(xpath = "//button[@id='send-and-set']")
   	public WebElement btn_Send;
    
    @FindBy(xpath = "//*[@class='display_emails']")
   	public WebElement mailID;
    
    @FindBy(xpath = "//*[text()='replied']")
   	public WebElement msgReplied;
    
    @FindBy(xpath = "//*[contains(@class,'ticket_note')]//*[text()]")
   	public WebElement msgTicketNote;
    
    @FindBy(xpath = "//a[@id='profileDropdown']")
   	public WebElement Profile_button;
	
	@FindBy(xpath = "//*[contains(text(),'Sign out')]")
   	public WebElement signout_button;
	
	@FindBy(xpath = "//a[text()='Ticket']")
   	public WebElement Ticket;
	
	@FindBy(xpath = "//input[@id='support-search-input']")
	public WebElement searchbox;

    @FindBy(xpath = "//input[@id='support-search-input']//following::a")
	public WebElement searchedtext;
    
    @FindBy(xpath = "//*[@class='fc-article-show article-view']//following::h6")
	public WebElement searchresult;
    
    @FindBy( xpath= "//*[text()='Customer Hash']")
	public WebElement customerhashtext;
	
	@FindBy( xpath= "//*[text()='Customer Hash']/following-sibling::*")
	public WebElement customerhash;
	
	@FindBy( xpath= "//*[text()='Edit']")
	public WebElement editbutton;
	
	@FindBy( xpath= "//label[text()='Customer Hash']/following-sibling::*")
	public WebElement entercustomerhash;
	
	@FindBy( xpath= "//*[text()='Save']")
	public WebElement savebutton;
	
	@FindBy( xpath= "//p[text()='Contact updated']")
	public WebElement contactupdatedbutton;
	
	@FindBy( xpath= "//*[@*='nav-tdl---360']")
	public WebElement Tdl_360;
	
	@FindBy( xpath= "(//*[contains(text(),'Search')])[2]")
	public WebElement searchbutton;
		
	@FindBy( xpath= "//*[text()='Loyalty Transactions']")
	public WebElement loyalty_transaction_click;
	
	@FindBy( xpath= "//*[@id='transactioninfo']//tr[1]//td[1]']")
	public WebElement loyalty_transaction_check;
	
	@FindBy( xpath= "//span[contains(@id,'clientidselect')]")
	public WebElement dropdown;
	
	@FindBy( xpath= "//input[@type='search']")
	public WebElement dropdown_option;
	
	@FindBy( xpath= "//li[@role='treeitem']")
	public WebElement dropdown_option_select;
	
	@FindBy( xpath= "//*[@id='profile-fullName']")
	public WebElement profilename;
	
	@FindBy( xpath= "//*[text()='Agent'][1]")
	public WebElement agentdetails;
	
	@FindBy( xpath= "//*[@aria-label='More']")
	public WebElement click_more_button;
	
	@FindBy( xpath= "//*[@aria-label='Tickets']")
	public WebElement icon_Tickets;
	
	@FindBy( xpath="//input[@placeholder='Search fields']")
	public WebElement search_Filters;
	
	@FindAll( @FindBy(xpath="//*[@*='remove element']"))
	public List<WebElement> removeTags;
	
	@FindBy( xpath="//button[text()='Apply']")
	public WebElement btnApply;
	
	@FindBy( xpath="//img[@alt='Qmin']")
	public WebElement optionQmin;
	
	@FindBys(@FindBy(xpath="//a[@class='child-transactions']"))
	public List<WebElement> allOrderLinks;
	
	@FindBy( xpath="//*[@data-test-id='filter-view-search']")
	public WebElement searchbuttonclick;

	@FindBy( xpath="//a[@id='addgoodwillpoints']")
	public WebElement lnkAddGoodwillPoints;
	
	@FindBy( xpath="//*[contains(@id,'save-addGoodwill')]")
	public WebElement btnAddGoodwill;
	
	@FindBy( xpath="//*[contains(text(),'Action performed: Add goodwill points')]")
	public WebElement msgAddGoodwillPoints;
	
	@FindBy( xpath="//*[contains(text(),'Action performed: Add goodwill points')]/ancestor::div[@*='conversation-wrapper']//button[@*='Delete']")
	public WebElement btnDelete_MsgBoxGoodwillAdded;
	
	
	@FindBy( xpath="//a[@id='customer_details']")
	public WebElement link_customerdetails;
	
	@FindBy( xpath="//table[contains(@id,'restaurant')]//tr[3]/td[1]")
	public WebElement restraunt_name;
	
	@FindBy( xpath="//*[text()='GRAND TOTAL']/following::*[1]")
	public WebElement total_amount;
	
	@FindBys({@FindBy(id="//table[contains(@id,'restaurant')]//tr[3]/td")})
	public List<WebElement> multiple_hotel;
	
	@FindBy( xpath="//*[contains(text(),'Initiate Refund')]")
	public WebElement initiate_refund;
	
	@FindBy( xpath="//input[@placeholder='Search With Keyword']")
	public WebElement search_field;
	
	@FindBy( xpath="//table[@id='itemListRefund']//tr[2]/td[1]")
	public WebElement item_select;
	
	@FindBy( xpath="//*[text()='Proceed']")
	public WebElement proceed_button;
	
	@FindBy( xpath="//*[text()='Approved by']/following::*")
	public WebElement approver_mail;
	
	@FindBy( xpath="//*[text()='Reason']/following::*")
	public WebElement approval_reason;
	
	@FindBy( xpath="//*[text()='Initiate']")
	public WebElement initiate_refund1;
	
	//20.01.21
	@FindBy( xpath="//*[@data-test-id='breadcrumb-item']")
	public WebElement ticket_id;
	
	@FindBy( xpath="//*[text()='Contact details']")
	public WebElement contact_details_icon;
	
	@FindBy( xpath="//*[@*='nav-dropdown-link-more-links']")
	public WebElement threedotbutton;
	
	@FindBy( xpath="//*[@*='nav-chat']")
	public WebElement btnChat;
	
	@FindBy( xpath="//*[contains(@*,'filter-dropdown')]/button")
	public WebElement dropdownFreshChat;
	
	@FindBy( xpath="//*[@id='aw-header-wrapper']//*[text()='New']")
	public WebElement btnNew;
	
	@FindBys(@FindBy(xpath="//*[@*='first-line']//span"))
	public List<WebElement> UserValidation;
	
	//21.01.21
	@FindBy( xpath="//img[@alt='Payment Transactions(SIT)']")
	public WebElement payment_tab;
	//for expanding payment section
	@FindBy( xpath="//img[@alt='User Consent ( SIT )']")
	public WebElement userconsentsit_tab;
	//for expanding icici dispute section
	@FindBy( xpath="//img[@alt='Customer Profile']")
	public WebElement customerprofile_tab;
	
	@FindBy(xpath="//*[contains(@*,'customer-name')]")
	public WebElement payment_details;
	
	@FindBy(xpath="//*[contains(text(),'Order No:')]/following::*")
	public WebElement orderid_click;
	
	@FindBy( xpath="//*[text()='Is Merchant']")
	public WebElement transaction_id;
	
	@FindBy( xpath="//*[@class='close']")
	public WebElement close_button;
	
	@FindBy( xpath="//img[@alt='ICICI Dispute']")
	public WebElement iciciDispute;
	
	@FindBy( xpath="//*[@id='createsr']")
	public WebElement createsrbtn;
	
	@FindBy( xpath="//*[text()='New Service Request']")
	public WebElement upiTransactionIDInputField1;
	
	@FindBy( xpath="//*[@id='title-createSr']")
	public WebElement upiTransactionIDInputField;
	
	@FindBy( xpath="//*[text()='added a private note']")
	public WebElement private_note;
	
	@FindAll(@FindBy(xpath = "//div[contains(text(),'Action performed')]"))
	public List<WebElement> messagenote;
	
	@FindBy( xpath="//img[@alt='Offers(SIT)']")
	public WebElement scrollto_offer;
	
	@FindBy( xpath="//*[@data-pnl='pnlvpa']")
	public WebElement upi_validation;
	
	@FindBy( xpath="//*[@id='statusselect']")
	public WebElement status_dropdown_click;
	
	@FindBy( xpath="//*[@id='statussearch']")
	public WebElement search_click;
	
	@FindBy( xpath="//*[@class='health-info']")
	public WebElement vpa_health_check;
	
	@FindBy( xpath="//*[@id='selectsearch']")
	public WebElement option_dropdown;
	
	@FindBy( xpath="//input[@placeholder='UTR#']")
	public WebElement utr_input;
	
	@FindBy( xpath="//*[contains(text(),'Order ID ')]")
	public WebElement order_id;
	//================================//
	@FindBy( xpath="//*[@id='agent-msg-submit']//input")
	public WebElement queryinputField;
	
	@FindBy( xpath="//*[contains(text(),'I have raised a ticket')]//strong")
	public WebElement getTicketno;
	
	@FindBy( xpath="//*[contains(text(),'I'm good, Thanks')]")
	public WebElement Nobtn;
	
	@FindBy( xpath="//*[@star-index='5']")
	public WebElement fiveStarbtn;
	
	@FindBy( xpath="//*[text()='My cards']")
	public WebElement mycards_click;
	
	@FindBy( xpath="//*[text()='U Points']")
	public WebElement view_details_click;
	
	@FindBy( xpath="//*[text()='Talk to Us']")
	public WebElement talktous_button;
	
	@FindBy( xpath="//*[@id='widget-header']")
	public WebElement chatbtnInHeader;
	
	@FindBy( xpath="//a[@href='/vault']")
	public WebElement vault_button;
	
	@FindBy( xpath="//*[@id='modal-close-button']")
	public WebElement close_button_tcp;
	
	@FindBy( xpath="//*[@data-test-id='ticket-status']")
	public WebElement ticket_status;
	
	@FindBy( xpath="//*[@title='Status']")
	public WebElement status_tab;
	
	@FindBy( xpath="//*[text()='Activity']/following::div[4]")
	public WebElement transactions;
	
	@FindBy( xpath="//table[@class='RefundTable']//tr[2]")
	public WebElement membership_table_ihcl;
	
	@FindBy( xpath="//table[@class='RefundTable']//tr[3]")
	public WebElement membership_table_airasia;
	
	@FindBy( xpath="//*[contains(text(),'m good, Thanks!')]")
	public WebElement chat_exit_button;
	
	@FindBy( xpath="//*[text()='Feedback']")
	public WebElement feedback_text;
	
	@FindBy( xpath="//*[@class='mandate-info']")
	public WebElement pendingotmdetails;
	
	@FindBy( xpath="//*[contains(text(),'Is Revokable')]")
	public WebElement revokeflag;
	
	@FindBy( xpath="//*[contains(text(),'Is Revokable')]//following::li")
	public WebElement revokeflagdetails;
	
	@FindBy( xpath="//*[text()='Tags']/following::input[1]")
	public WebElement tagstab;
	
	@FindBy( xpath="//*[text()='SN Ticket ID']")
	public WebElement snticketidtab;
}
