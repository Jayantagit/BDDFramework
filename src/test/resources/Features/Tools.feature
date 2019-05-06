Feature: Tools Module Scenarios

@Sanity 
Scenario Outline: This scenario is to test the FindDuplicate Functionality
	Given User navigate to the MergeDuplicate Page
	When user select the module "<Module>" and click the FindDuplicate Link
	And Click the Email Checkbox and Search Button
	Then Check for the Search Result

    Examples: 
      | Module     | 
      | Leads      |
