import React from 'react';
import { render, fireEvent, waitFor, screen } from '@testing-library/react';
import '@testing-library/jest-dom/extend-expect'; // For expect(...).toBeInTheDocument()
import AddUser from '../src/Component/AddUser'; // Adjust the import path as needed

// Mock the useNavigate hook from react-router-dom
jest.mock('react-router-dom', () => ({
  useNavigate: jest.fn(),
}));

// Mock the fetch function
global.fetch = jest.fn(() =>
  Promise.resolve({
    text: () => Promise.resolve('false'), // Mock the response from the server
    ok: true,
  })
);

describe('AddUser Component', () => {
  it('renders the component without errors', () => {
    render(<AddUser />);
    // You can add more specific assertions here if needed
    expect(screen.getByText('Please, Enter your Details')).toBeInTheDocument();
  });

  it('displays an error message when the email is invalid', async () => {
    render(<AddUser />);
    const emailInput = screen.getByPlaceholderText('Enter Your Email id');
    const submitButton = screen.getByText('Submit');

    fireEvent.change(emailInput, { target: { value: 'invalid-email' } });
    fireEvent.click(submitButton);

    await waitFor(() => {
      expect(screen.getByTestId('emailid-error-msg')).toHaveTextContent(
        'Please enter a valid email address'
      );
    });
  });

  it('displays an error message when the email already exists', async () => {
    // Mock the fetch function to simulate an existing email
    global.fetch = jest.fn(() =>
      Promise.resolve({
        text: () => Promise.resolve('true'), // Email already exists
        ok: true,
      })
    );

    render(<AddUser />);
    const emailInput = screen.getByPlaceholderText('Enter Your Email id');
    const submitButton = screen.getByText('Submit');

    fireEvent.change(emailInput, { target: { value: 'existing-email@example.com' } });
    fireEvent.click(submitButton);

    await waitFor(() => {
      expect(screen.getByTestId('emailid-error-msg')).toHaveTextContent(
        'Email Aleady Exists!!!!!!!!'
      );
    });
  });

  // Add more test cases for other form fields and interactions as needed
});
