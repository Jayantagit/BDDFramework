Feature: Sales Module Scenarios

@Sanity 
Scenario Outline: This scenario is to test the Quick Search Functionality
	Given Already Logged in to ConvergeHub site
	When I navigate to Lead List and enter the Name "<Name>" for Quick Search
	Then Search result will appear

    Examples: 
      | Name       | 
      | Test       |
