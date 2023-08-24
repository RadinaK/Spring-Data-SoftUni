<h3>05.2 E-commercial backend - Extended</h3>
<h4>Expand the E-commerce backend application with the following functionality:</h3>

<p>1. Add functionality for discounted (promotional) products. Each product can have a
standard price or be on promotion. Implement functionality to specify the
percentage promotion and the duration of the promotion. When adding a product to
the shopping cart during a promotion, its price should be the promotional price. If
a product has a defined promotional period but it is not active yet, its price in the
cart should be the standard price.</p>

<p>2. Due to potentially increased interest in promotional products, implement
functionality to limit the maximum number of units a customer can purchase. The
maximum limit should apply only to promotional products and specific ones.</p>

<p>3. Implement functionality for a "Loyalty" card. This card provides a promotion for
certain items that are currently not on standard promotion (from point 1). The
promotion is applied automatically when the card number is entered during
payment. The final payment amount is calculated based on products with
standard prices, products on promotion, and products on promotion with the
"Loyalty" card.</p>

<p>4. Implement functionality for "User (Customer)". The user contains information
about the person behind it. Additionally, their order history is stored. The user can
have a "Loyalty" card, which can be issued when the user reaches a certain
turnover amount (1000 BGN), within a maximum period of one month. Once
issued, the card is valid for one year. Its validity is renewed every month when
the customer reaches the specified turnover for the initial card issuance - 1000
BGN.</p>

<p>5. Implement functionality for "Family". A family is a group of users (customers) who
share a common shopping history and a "Loyalty" card. A family can have a
maximum of five members, with no more than three of them being adults. The
minimum age for a user of the application, and respectively a member of the
"Family," is 8 years. Users below this age cannot register in the system.</p>

<p>6. Implement "Authentication" functionality. This includes requiring a username and
password from the user to access their profile.</p>
